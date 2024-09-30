package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JTable;

import logica.IControladorActividad;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import datatype.DtActividad;
import excepciones.PersistenciaException;

public class VtAceptarActividad extends JInternalFrame{
	private JInternalFrame yo = this;
	private IControladorActividad iControladorActividad;
	private VtPrincipal principal;
	private JButton btnCerrar;
	private JTextField textDescripcion;
	private JTextField textNombre;
	private JTextField textDuracion;
	private JTextField textCosto;
	private JTextField textLugar;
	private JTextField textFechaAlta;
	private JTextField textEstado;
	private JList<String> listActividades;
	
	public VtAceptarActividad(IControladorActividad i, VtPrincipal VtPrincipal) {
		setTitle("Aceptar Actividad");
		principal = VtPrincipal;
		iControladorActividad = i;
		principal.bajarFrameActual();
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize( 650, 370);
		getContentPane().setLayout(null);	
		getContentPane().setBackground(Color.decode("#cbdad5"));
		principal.setFrameActual(yo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yo.dispose();
			}
		});
		btnCerrar.setBounds(246, 308, 262, 21);
		this.getContentPane().add(btnCerrar);
		
		listActividades = new JList<String>();
		listActividades.setBounds(10, 11, 226, 318);
		getContentPane().add(listActividades);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textNombre.getText().equals("")) {
					actualizarEstado(true);
					try {
						cargarListaActividades();
					} catch (PersistenciaException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnAceptar.setBounds(246, 274, 120, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnRechazar = new JButton("Rechazar");
		btnRechazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textNombre.getText().equals("")) {
					actualizarEstado(false);
					try {
						cargarListaActividades();
					} catch (PersistenciaException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnRechazar.setBounds(388, 274, 120, 23);
		getContentPane().add(btnRechazar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(246, 14, 47, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(246, 39, 86, 14);
		getContentPane().add(lblDescripcion);
		
		textDescripcion = new JTextField();
		textDescripcion.setEnabled(false);
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(246, 58, 262, 60);
		getContentPane().add(textDescripcion);
		
		textNombre = new JTextField();
		textNombre.setEnabled(false);
		textNombre.setColumns(10);
		textNombre.setBounds(318, 11, 190, 20);
		getContentPane().add(textNombre);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(246, 129, 62, 14);
		getContentPane().add(lblDuracion);
		
		textDuracion = new JTextField();
		textDuracion.setEnabled(false);
		textDuracion.setColumns(10);
		textDuracion.setBounds(318, 126, 190, 20);
		getContentPane().add(textDuracion);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(246, 154, 62, 14);
		getContentPane().add(lblCosto);
		
		textCosto = new JTextField();
		textCosto.setEnabled(false);
		textCosto.setColumns(10);
		textCosto.setBounds(318, 151, 190, 20);
		getContentPane().add(textCosto);
		
		textLugar = new JTextField();
		textLugar.setEnabled(false);
		textLugar.setColumns(10);
		textLugar.setBounds(318, 176, 190, 20);
		getContentPane().add(textLugar);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(246, 179, 62, 14);
		getContentPane().add(lblLugar);
		
		JLabel lblFechaAlta = new JLabel("Fecha alta");
		lblFechaAlta.setBounds(246, 204, 62, 14);
		getContentPane().add(lblFechaAlta);
		
		textFechaAlta = new JTextField();
		textFechaAlta.setEnabled(false);
		textFechaAlta.setColumns(10);
		textFechaAlta.setBounds(318, 201, 190, 20);
		getContentPane().add(textFechaAlta);
		
		textEstado = new JTextField();
		textEstado.setEnabled(false);
		textEstado.setColumns(10);
		textEstado.setBounds(318, 226, 190, 20);
		getContentPane().add(textEstado);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(246, 229, 62, 14);
		getContentPane().add(lblEstado);
		
		//EVENTOS ========================================================================
		
		addComponentListener ( new ComponentAdapter () {
	        public void componentShown ( ComponentEvent e ) {
	        	//ejecuta la funcion al cambiar el estado 'visible' del frame a true
	            try {
					cargarListaActividades();
				} catch (PersistenciaException e1) {
					e1.printStackTrace();
				}
	        }
	    });
		
		listActividades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Coloca el nombre de la clase seleccionada en el textBox para buscar
				textNombre.setText(listActividades.getSelectedValue());
				//Traer objeto actividad
				DtActividad act = iControladorActividad.obtenerActividad(textNombre.getText());
				//Mostrar la info en los campos de texto
				textDescripcion.setText(act.getDescripcion());
				textDuracion.setText(String.valueOf(act.getDuracionHoras()));
				textCosto.setText(String.valueOf(act.getCosto()));
				textLugar.setText(act.getLugar());
				textFechaAlta.setText(act.getFechaAlta().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
				textEstado.setText(act.getEstado());
			}
		});
		
	}
	
	private void cargarListaActividades() throws PersistenciaException {
		//limpia la lista
		listActividades.removeAll();
		//completar la lista con datos
		listActividades.setListData(iControladorActividad.obtenerVectorActividadesPendientes());
	}
	
	private void actualizarEstado(boolean estado) {
		iControladorActividad.actualizarEstado(estado, textNombre.getText());
	}
}
