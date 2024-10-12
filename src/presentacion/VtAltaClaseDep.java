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
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import excepciones.ClaseRepetidoException;
import excepciones.PersistenciaException;
import logica.IControladorActividad;
import logica.IControladorClaseDeportiva;

import javax.swing.JList;
import javax.swing.JOptionPane;

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
	private JList listActividades;
	
	public VtAltaClaseDep(IControladorClaseDeportiva icc,IControladorActividad ia, VtPrincipal VtPrincipal) {
		
		//Inicio el controlador usuario
		iControladorActividad = ia;
		iControladorClase = icc;
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
		
		listActividades = new JList();
		listActividades.setBounds(10, 15, 147, 314);
		getContentPane().add(listActividades);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					coinfirmarAltaClase();
				} catch (PersistenciaException | ClaseRepetidoException e1) {
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
					vActividades = iControladorActividad.obtenerVectorActividadesAceptadas();
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
	
	private void coinfirmarAltaClase() throws PersistenciaException, ClaseRepetidoException{
		//Guardo los datos en variables
		String nombreClase =  textNombre.getText();
		String nombreAct = textNombreAct.getText();			
		String cupo = textCupos.getText();
		String lugar = textLugar.getText();
		String fecha = textFecha.getText();
		String fechaAlta =  textFechaAlta.getText();
		String hora = textHora.getText();
		
		//Verifico campos vacios
		if (lugar.isEmpty() ||nombreClase.isEmpty() ||nombreAct.isEmpty() || cupo.isEmpty() ||fecha.isEmpty() || fechaAlta.isEmpty() ||hora.isEmpty()) {    
			JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//Verifico que el cupo sea un numero
		if (!cupo.matches("\\d+")) {
		    JOptionPane.showMessageDialog(this, "El cupo debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
		    return;
		}
		
		//Verifico que la fecha sea con el formato correcto
		if (!Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$").matcher(fecha).matches()) {
			JOptionPane.showMessageDialog(this, "El formato de la Fecha no es válido, usar 'dd/mm/aaaa'", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//Verifico que la hora sea con el formato correcto
		if (!Pattern.compile("^([01]\\d|2[0-3]):[0-5]\\d$").matcher(hora).matches()) {
		    JOptionPane.showMessageDialog(this, "El formato de la Hora no es válido, usar 'hh:mm'", "Error", JOptionPane.ERROR_MESSAGE);
		    return;
		}
		
		//Doy formato a la fecha y hora antes de guardarla
		 DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
		 LocalDate fechaFor = LocalDate.parse(textFecha.getText(), formatoFecha);
		 LocalTime horaFor = LocalTime.parse(textHora.getText(), formatoHora);
		//Pasero a int
		 Integer cupos = Integer.parseInt(textCupos.getText());
		 
		//Verifico si existe el nombre de la clase
		if(iControladorClase.claseExiste(nombreClase)) {
			JOptionPane.showMessageDialog(this, "Ya exite una clase con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		 
		try {
			iControladorClase.AltaClaseDeportiva(textNombre.getText(), fechaFor, horaFor, textLugar.getText(), cupos,LocalDate.now(), iControladorActividad.obtenerActividad((String) listActividades.getSelectedValue()), null);
		} catch (PersistenciaException e1) {
			e1.printStackTrace();
		}
		
		//Limmpio los campos y oculto el panel
		yo.dispose();
	}
	
}