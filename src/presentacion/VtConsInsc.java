package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class VtConsInsc extends JInternalFrame{
	JButton btnCerrar;
	private JInternalFrame yo = this;
	private VtPrincipal principal;
	private JTextField textFechaAlta;
	private JTextField textCupos;
	private JTextField textLugar;
	private JTextField textHora;
	private JTextField textFecha;
	public VtConsInsc(VtPrincipal VtPrincipal) {

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
		listClases.setBounds(226, 36, 206, 138);
		getContentPane().add(listClases);

		JLabel lblClases = new JLabel("Clases");
		lblClases.setBounds(226, 11, 148, 14);
		getContentPane().add(lblClases);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(226, 185, 85, 14);
		getContentPane().add(lblFecha);

		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(226, 210, 85, 14);
		getContentPane().add(lblHora);

		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(226, 235, 85, 14);
		getContentPane().add(lblLugar);

		JLabel lblCupos = new JLabel("Cupos");
		lblCupos.setBounds(226, 260, 85, 14);
		getContentPane().add(lblCupos);

		JLabel lblFechaAlta = new JLabel("Fecha de alta");
		lblFechaAlta.setBounds(226, 285, 85, 14);
		getContentPane().add(lblFechaAlta);

		textFechaAlta = new JTextField();
		textFechaAlta.setEnabled(false);
		textFechaAlta.setBounds(332, 282, 100, 20);
		getContentPane().add(textFechaAlta);
		textFechaAlta.setColumns(10);

		textCupos = new JTextField();
		textCupos.setEnabled(false);
		textCupos.setColumns(10);
		textCupos.setBounds(332, 257, 100, 20);
		getContentPane().add(textCupos);

		textLugar = new JTextField();
		textLugar.setEnabled(false);
		textLugar.setColumns(10);
		textLugar.setBounds(332, 232, 100, 20);
		getContentPane().add(textLugar);

		textHora = new JTextField();
		textHora.setEnabled(false);
		textHora.setColumns(10);
		textHora.setBounds(332, 207, 100, 20);
		getContentPane().add(textHora);

		textFecha = new JTextField();
		textFecha.setEnabled(false);
		textFecha.setColumns(10);
		textFecha.setBounds(332, 182, 100, 20);
		getContentPane().add(textFecha);

		JList listInscripciones = new JList();
		listInscripciones.setBounds(442, 36, 206, 235);
		getContentPane().add(listInscripciones);

		JLabel lblDeportista = new JLabel("Inscripciones");
		lblDeportista.setBounds(442, 11, 206, 14);
		getContentPane().add(lblDeportista);
	}
}