package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import excepciones.ClaseRepetidoException;
import excepciones.PersistenciaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import logica.IControladorActividad;
import logica.IControladorClaseDeportiva;
import logica.IControladorUsuario;
import modelo.Actividad;

import javax.swing.JList;

public class VtAltaClaseDep extends JInternalFrame{
	JButton btnCancelar;
	private JInternalFrame yo = this;
	private VtPrincipal principal;
	private JTextField textNombre;
	private JTextField textFecha;
	private JTextField textHora;
	private JTextField textLugar;
	private JTextField textCupos;
	private JTextField textFechaAlta;
	private IControladorActividad iControladorActividad;
	private IControladorClaseDeportiva iControladorClase;
	private JTextField textNombreAct;
	
	public VtAltaClaseDep(IControladorActividad ia, VtPrincipal VtPrincipal) {
		
		//Inicio el controlador usuario
		iControladorActividad = ia;
		setTitle("Alta Clase");
		principal = VtPrincipal;
		principal.bajarFrameActual();
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize( 650, 370);
		getContentPane().setLayout(null);	
		getContentPane().setBackground(Color.decode("#cbdad5"));
		principal.setFrameActual(yo);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yo.dispose();
			}
		});
		btnCancelar.setBounds(356, 207, 105, 21);
		this.getContentPane().add(btnCancelar);
		
		JLabel lblActividad = new JLabel("Actividad");
		lblActividad.setBounds(199, 18, 105, 14);
		getContentPane().add(lblActividad);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(199, 45, 105, 14);
		getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(314, 42, 147, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(199, 70, 105, 14);
		getContentPane().add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(199, 95, 105, 14);
		getContentPane().add(lblHora);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(199, 120, 105, 14);
		getContentPane().add(lblLugar);
		
		JLabel lblCupos = new JLabel("Cupos");
		lblCupos.setBounds(199, 145, 105, 14);
		getContentPane().add(lblCupos);
		
		JLabel lblFechaAlta = new JLabel("Fecha de alta");
		lblFechaAlta.setBounds(199, 170, 105, 14);
		getContentPane().add(lblFechaAlta);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(314, 67, 147, 20);
		getContentPane().add(textFecha);
		
		textHora = new JTextField();
		textHora.setColumns(10);
		textHora.setBounds(314, 92, 147, 20);
		getContentPane().add(textHora);
		
		textLugar = new JTextField();
		textLugar.setColumns(10);
		textLugar.setBounds(314, 117, 147, 20);
		getContentPane().add(textLugar);
		
		textCupos = new JTextField();
		textCupos.setColumns(10);
		textCupos.setBounds(314, 142, 147, 20);
		getContentPane().add(textCupos);
		
		textFechaAlta = new JTextField();
		textFechaAlta.setEditable(false);
		textFechaAlta.setColumns(10);
		textFechaAlta.setBounds(314, 167, 147, 20);
		getContentPane().add(textFechaAlta);
		
		JList listActividades = new JList();
		listActividades.setBounds(10, 15, 147, 314);
		getContentPane().add(listActividades);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				 DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("hh:mm");
				 LocalDate fecha = LocalDate.parse(textFecha.getText(), formatoFecha);
				 LocalTime hora = LocalTime.parse(textHora.getText(), formatoFecha);
				 
				 
				 
				 try {
					iControladorClase.AltaClaseDeportiva(textNombre.getText(), fecha, hora, textLugar.getText(), Integer.parseInt(textCupos.getText()),LocalDate.now(), ia.obtenerActividad((String) listActividades.getSelectedValue()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClaseRepetidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (PersistenciaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
			}
		});
		btnConfirmar.setBounds(241, 206, 105, 21);
		getContentPane().add(btnConfirmar);
		

		
		textNombreAct = new JTextField();
		textNombreAct.setEditable(false);
		textNombreAct.setColumns(10);
		textNombreAct.setBounds(314, 15, 147, 20);
		getContentPane().add(textNombreAct);
		
		addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				
				textFechaAlta.setText(LocalDate.now().toString());
			
				Vector<String> vActividades = null;
				try {
					vActividades = iControladorActividad.obtenerVectorUsuarios();
				} catch (PersistenciaException e1) {
					e1.printStackTrace();
				}
				if (!vActividades.isEmpty()) {
					listActividades.setListData(vActividades);
				}
			}
		});
		
		listActividades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textNombreAct.setText((String) listActividades.getSelectedValue());
			}
		});

		
	}	
}