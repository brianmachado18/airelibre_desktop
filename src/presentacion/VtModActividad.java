package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import datatype.DtActividad;
import datatype.DtEntrenador;
import excepciones.PersistenciaException;
import logica.*;
import javax.swing.JList;

@SuppressWarnings("serial")
public class VtModActividad extends JInternalFrame {
	private JTextField textNombre;
	private JTextField textDescripcion;
	private JTextField textDuracion;
	private JTextField textCosto;
	private JTextField textLugar;
	private JTextField textFecha;
	private JTextField textIMG;
	private JComboBox<String> cbEntrenador;
	private IControladorUsuario iControladorUsuario;
	private IControladorActividad iControladorActividad;
	private VtPrincipal principal;
	private JInternalFrame yo = this;
	private JButton btnCancelar;
	private JButton btnConfirmar;
	private JButton btnBuscar;

	public VtModActividad(IControladorUsuario iu, IControladorActividad ia, VtPrincipal VtPrincipal) {
		principal = VtPrincipal;

		iControladorUsuario = iu;
		iControladorActividad = ia;
		principal.bajarFrameActual();
		setTitle("Modificar Actividad");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize( 472, 286);
		getContentPane().setLayout(null);	
		getContentPane().setBackground(Color.decode("#cbdad5"));
		principal.setFrameActual(yo);

		JLabel lblEntrenador = new JLabel("Entrenador");
		lblEntrenador.setBounds(172, 54, 128, 14);
		getContentPane().add(lblEntrenador);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(172, 16, 128, 14);
		getContentPane().add(lblNombre);

		cbEntrenador = new JComboBox<String>();
		cbEntrenador.setBounds(295, 51, 152, 20);
		getContentPane().add(cbEntrenador);
		cbEntrenador.setSelectedIndex(-1);

		textNombre = new JTextField();
		textNombre.setBounds(227, 13, 105, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(172, 82, 128, 14);
		getContentPane().add(lblDescripcion);

		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(172, 107, 128, 14);
		getContentPane().add(lblDuracion);

		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(172, 132, 128, 14);
		getContentPane().add(lblCosto);

		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(172, 157, 128, 14);
		getContentPane().add(lblLugar);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(172, 182, 128, 14);
		getContentPane().add(lblFecha);

		textIMG = new JTextField();		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(295, 79, 152, 20);
		getContentPane().add(textDescripcion);

		textDuracion = new JTextField();
		textDuracion.setColumns(10);
		textDuracion.setBounds(295, 104, 152, 20);
		getContentPane().add(textDuracion);

		textCosto = new JTextField();
		textCosto.setColumns(10);
		textCosto.setBounds(295, 129, 152, 20);
		getContentPane().add(textCosto);

		textLugar = new JTextField();
		textLugar.setColumns(10);
		textLugar.setBounds(295, 154, 152, 20);
		getContentPane().add(textLugar);

		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(295, 179, 152, 20);
		getContentPane().add(textFecha);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		
		btnConfirmar.setBounds(177, 223, 130, 21);
		this.getContentPane().add(btnConfirmar);

		btnCancelar = new JButton("Salir");
		btnCancelar.setBounds(317, 223, 130, 21);
		this.getContentPane().add(btnCancelar);
		
		JList<String> listActividades = new JList<String>();
		listActividades.setBounds(10, 15, 152, 229);
		getContentPane().add(listActividades);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(342, 12, 105, 21);
		getContentPane().add(btnBuscar);

		//EVENTOS =============================================
		addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				listActividades.setListData(iControladorActividad.obtenerVectorActividad());
			}
		});
		
		listActividades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnCancelar.getText().compareTo("Salir")==0) {
					textNombre.setText(listActividades.getSelectedValue());
				}
			}
		});

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					confirmarModActividad();
				} catch (PersistenciaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelar.setText("Cancelar");
				setCamposEnable(true);
				// COMPLETAR CAMPOS
				DtActividad act = iControladorActividad.obtenerActividad(textNombre.getText());
				try {
					for (String en : iControladorUsuario.obtenerListaEntrenadores()) {
						cbEntrenador.addItem(en);
					}
					cbEntrenador.setSelectedItem(act.getEntrenador().getNombre());
				} catch (PersistenciaException e1) {
					e1.printStackTrace();
				}
				textDescripcion.setText(act.getDescripcion());
				textDuracion.setText(String.valueOf(act.getDuracionHoras()));
				textCosto.setText(String.valueOf(act.getCosto()));
				textLugar.setText(act.getLugar());
				textFecha.setText(act.getFechaAlta().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnCancelar.getText().compareTo("Salir")==0) {
					yo.dispose();
				} else {
					limpiarCampos();
					setCamposEnable(false);
					btnCancelar.setText("Salir");
				}
			}
		});
		
	}
	
	private void setCamposEnable(boolean b) {
		textNombre.setEnabled(!b);
		btnBuscar.setEnabled(!b);
		cbEntrenador.setEnabled(b);
		textDescripcion.setEnabled(b);
		textDuracion.setEnabled(b);
		textCosto.setEnabled(b);
		textLugar.setEnabled(b);
		textFecha.setEnabled(b);
		btnConfirmar.setEnabled(b);
	}
	
	private void limpiarCampos() {
		cbEntrenador.removeAllItems();
		textDescripcion.setText(null);
		textDuracion.setText(null);
		textCosto.setText(null);
		textLugar.setText(null);
		textFecha.setText(null);
	}
	
	private void confirmarModActividad() throws PersistenciaException{
		//Guardo los datos en variables
		String nombre =  textNombre.getText();
		String desc = textDescripcion.getText();
		String duracionHora =  textDuracion.getText();
		String costo = textCosto.getText();
		String lugar = textLugar.getText();
		String fecha = textFecha.getText();
		String img = textIMG.getText();
		String ent = cbEntrenador.getSelectedItem().toString();
		
		if (nombre.isEmpty() || desc.isEmpty() || duracionHora.isEmpty() || costo.isEmpty() || lugar.isEmpty() || fecha.isEmpty()) {    
			JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (!duracionHora.matches("[0-9]")) {
		    JOptionPane.showMessageDialog(this, "La duración debe ser un número entre 0 y 9", "Error", JOptionPane.ERROR_MESSAGE);
		    return;
		}
		
		if (!costo.matches("\\d+")) {
		    JOptionPane.showMessageDialog(this, "El costo debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
		    return;
		}
		
		if (!Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$").matcher(fecha).matches()) {
			JOptionPane.showMessageDialog(this, "El formato de la Fecha no es válido, usar 'dd/mm/aaaa'", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//Obtiene el objeto del entrenador seleccionado
		DtEntrenador traerEntrador = iControladorUsuario.obtenerEntrenador(ent);
		
		//Ingresa los datos a la bd
		LocalDate fechaAux = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		iControladorActividad.modificarActividad(nombre, desc, Integer.parseInt(duracionHora), Integer.parseInt(costo), lugar, fechaAux,  img, traerEntrador);
		
		//Limmpio los campos y oculto el panel
		yo.dispose();
	}
}
