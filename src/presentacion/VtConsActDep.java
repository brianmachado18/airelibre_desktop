package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JList;
import java.awt.List;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VtConsActDep extends JInternalFrame{
	private JTextField textNombre;
	private JTextField textDescripcion;
	private JTextField textDuracion;
	private JTextField textCosto;
	private JTextField textLugar;
	private JTextField textFechaAlta;
	private JTextField textEstado;
	private JTextField textNombreClase;
	private JTextField textFechaClase;
	private JTextField textHoraClase;
	private JTextField textLugarClase;
	private JTextField textFechaAltaClase;
	private List listInscriptos;
	private List listActividades;
	private List listClases;
	private JInternalFrame yo = this;
	private VtPrincipal principal;
	
	public VtConsActDep(VtPrincipal VtPrincipal) {
		principal = VtPrincipal;
		principal.bajarFrameActual();
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Consulta Actividad");
		setSize( 650, 370);
		getContentPane().setLayout(null);	
		getContentPane().setBackground(Color.decode("#cbdad5"));
		principal.setFrameActual(yo);
		
		listActividades = new List();
		listActividades.setBounds(10, 10, 146, 314);
		getContentPane().add(listActividades);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(177, 29, 47, 14);
		getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(249, 26, 102, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(177, 54, 86, 14);
		getContentPane().add(lblDescripcion);
		
		textDescripcion = new JTextField();
		textDescripcion.setEnabled(false);
		textDescripcion.setBounds(177, 73, 262, 60);
		getContentPane().add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(177, 144, 62, 14);
		getContentPane().add(lblDuracion);
		
		textDuracion = new JTextField();
		textDuracion.setEnabled(false);
		textDuracion.setBounds(249, 141, 190, 20);
		getContentPane().add(textDuracion);
		textDuracion.setColumns(10);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(177, 169, 62, 14);
		getContentPane().add(lblCosto);
		
		textCosto = new JTextField();
		textCosto.setEnabled(false);
		textCosto.setColumns(10);
		textCosto.setBounds(249, 166, 190, 20);
		getContentPane().add(textCosto);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(177, 194, 62, 14);
		getContentPane().add(lblLugar);
		
		JLabel lblFechaAlta = new JLabel("Fecha alta");
		lblFechaAlta.setBounds(177, 219, 62, 14);
		getContentPane().add(lblFechaAlta);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(177, 244, 62, 14);
		getContentPane().add(lblEstado);
		
		textLugar = new JTextField();
		textLugar.setEnabled(false);
		textLugar.setColumns(10);
		textLugar.setBounds(249, 191, 190, 20);
		getContentPane().add(textLugar);
		
		textFechaAlta = new JTextField();
		textFechaAlta.setEnabled(false);
		textFechaAlta.setColumns(10);
		textFechaAlta.setBounds(249, 216, 190, 20);
		getContentPane().add(textFechaAlta);
		
		textEstado = new JTextField();
		textEstado.setEnabled(false);
		textEstado.setColumns(10);
		textEstado.setBounds(249, 241, 190, 20);
		getContentPane().add(textEstado);
		
		listClases = new List();
		listClases.setBounds(461, 54, 146, 270);
		getContentPane().add(listClases);
		
		JLabel lblClases = new JLabel("Clases");
		lblClases.setBounds(461, 29, 146, 14);
		getContentPane().add(lblClases);
		
		JLabel lblNombreClase = new JLabel("Nombre");
		lblNombreClase.setBounds(626, 54, 63, 14);
		getContentPane().add(lblNombreClase);
		
		JLabel lblFechaClase = new JLabel("Fecha");
		lblFechaClase.setBounds(626, 79, 63, 14);
		getContentPane().add(lblFechaClase);
		
		JLabel lblHoraClase = new JLabel("Hora");
		lblHoraClase.setBounds(626, 104, 63, 14);
		getContentPane().add(lblHoraClase);
		
		JLabel lblLugarClase = new JLabel("Lugar");
		lblLugarClase.setBounds(626, 129, 63, 14);
		getContentPane().add(lblLugarClase);
		
		JLabel lblFechaAltaClase = new JLabel("Fecha Alta");
		lblFechaAltaClase.setBounds(626, 154, 63, 14);
		getContentPane().add(lblFechaAltaClase);
		
		textNombreClase = new JTextField();
		textNombreClase.setEnabled(false);
		textNombreClase.setBounds(699, 51, 130, 20);
		getContentPane().add(textNombreClase);
		textNombreClase.setColumns(10);
		
		textFechaClase = new JTextField();
		textFechaClase.setEnabled(false);
		textFechaClase.setColumns(10);
		textFechaClase.setBounds(699, 76, 130, 20);
		getContentPane().add(textFechaClase);
		
		textHoraClase = new JTextField();
		textHoraClase.setEnabled(false);
		textHoraClase.setColumns(10);
		textHoraClase.setBounds(699, 101, 130, 20);
		getContentPane().add(textHoraClase);
		
		textLugarClase = new JTextField();
		textLugarClase.setEnabled(false);
		textLugarClase.setColumns(10);
		textLugarClase.setBounds(699, 126, 130, 20);
		getContentPane().add(textLugarClase);
		
		textFechaAltaClase = new JTextField();
		textFechaAltaClase.setEnabled(false);
		textFechaAltaClase.setColumns(10);
		textFechaAltaClase.setBounds(699, 151, 130, 20);
		getContentPane().add(textFechaAltaClase);
		
		JLabel lblInscriptos = new JLabel("Inscriptos");
		lblInscriptos.setBounds(626, 179, 203, 14);
		getContentPane().add(lblInscriptos);
		
		listInscriptos = new List();
		listInscriptos.setBounds(626, 202, 203, 122);
		getContentPane().add(listInscriptos);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(361, 25, 78, 23);
		getContentPane().add(btnBuscar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yo.dispose();
			}
		});
		btnCancelar.setBounds(249, 290, 190, 21);
		btnCancelar.setVisible(true);
		this.getContentPane().add(btnCancelar);
		
	    addComponentListener ( new ComponentAdapter () {
	        public void componentShown ( ComponentEvent e ) {
	        	//ejecuta la funcion al cambiar el estado 'visible' del frame a true
	            recargarListaActividades();
	        }
	    });
	}

	private void recargarListaActividades() {
		//limpia la lista
		listActividades.removeAll();
		//completar la lista con datos actualizados
	}
}