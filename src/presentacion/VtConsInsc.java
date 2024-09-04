package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import datatype.DtClaseDeportiva;
import logica.IControladorActividad;
import logica.IControladorClaseDeportiva;

public class VtConsInsc extends JInternalFrame{
	JButton btnCerrar;
	private JInternalFrame yo = this;
	private VtPrincipal principal;
	private IControladorActividad ICA;
	private IControladorClaseDeportiva ICC;
	
	public VtConsInsc(IControladorActividad ica,IControladorClaseDeportiva icc, VtPrincipal VtPrincipal) {

		ICA = ica;
		ICC = icc;
		setTitle("Inscripcion");
		principal = VtPrincipal;
		principal.bajarFrameActual();
		setTitle("Alta Actividad");
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
		btnCerrar.setBounds(442, 282, 206, 21);
		this.getContentPane().add(btnCerrar);

		JList listActividades = new JList();
		listActividades.setBounds(10, 36, 206, 266);
		getContentPane().add(listActividades);

		JLabel lblActividades = new JLabel("Actividades");
		lblActividades.setBounds(10, 11, 148, 14);
		getContentPane().add(lblActividades);

		JList listClases = new JList();
		listClases.setBounds(226, 36, 206, 267);
		getContentPane().add(listClases);

		JLabel lblClases = new JLabel("Clases");
		lblClases.setBounds(226, 11, 148, 14);
		getContentPane().add(lblClases);

		JList listInscripciones = new JList();
		listInscripciones.setBounds(442, 36, 206, 235);
		getContentPane().add(listInscripciones);

		JLabel lblDeportista = new JLabel("Inscripciones");
		lblDeportista.setBounds(442, 11, 206, 14);
		getContentPane().add(lblDeportista);
		

		addComponentListener ( new ComponentAdapter () {
	        public void componentShown ( ComponentEvent e ) {
	        	Vector<String> vActividades = null;
				vActividades = ICA.obtenerVectorActividad();
				if (!vActividades.isEmpty()) {
					listActividades.setListData(vActividades);
				}
	        }
	    });
		
		listActividades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vector<String> vClases = null;
				vClases = ICA.obtenerVectorClasesActividad(listActividades.getSelectedValue().toString());
				listClases.setListData(vClases);

			}
		});
		
		listClases.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vector<String> vInscripciones = null;
				vInscripciones = ICC.obtenerListaInscripciones(listClases.getSelectedValue().toString());
				listInscripciones.setListData(vInscripciones);

			}
		});
	}
}