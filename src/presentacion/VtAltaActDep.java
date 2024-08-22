package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class VtAltaActDep extends JInternalFrame{
	private JTextField textNombre;
	private JTextField textDescripcion;
	private JTextField textDuracion;
	private JTextField textCosto;
	private JTextField textLugar;
	private JTextField textFecha;
	JInternalFrame yo = this;
	public VtAltaActDep() {
		setTitle("Alta Actividad");
		this.getContentPane().setLayout(null);
		this.setBounds(26, 24, 311, 291);
		this.setVisible(false);
		
		JLabel lblEntrenador = new JLabel("Entrenador");
		lblEntrenador.setBounds(10, 22, 128, 14);
		getContentPane().add(lblEntrenador);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 60, 128, 14);
		getContentPane().add(lblNombre);
		
		JComboBox cbEntrenador = new JComboBox();
		cbEntrenador.setBounds(133, 18, 152, 22);
		getContentPane().add(cbEntrenador);
		cbEntrenador.setSelectedIndex(-1);
		
		textNombre = new JTextField();
		textNombre.setBounds(133, 57, 152, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 85, 128, 14);
		getContentPane().add(lblDescripcion);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(10, 110, 128, 14);
		getContentPane().add(lblDuracion);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(10, 135, 128, 14);
		getContentPane().add(lblCosto);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(10, 160, 128, 14);
		getContentPane().add(lblLugar);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 185, 128, 14);
		getContentPane().add(lblFecha);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(133, 82, 152, 20);
		getContentPane().add(textDescripcion);
		
		textDuracion = new JTextField();
		textDuracion.setColumns(10);
		textDuracion.setBounds(133, 107, 152, 20);
		getContentPane().add(textDuracion);
		
		textCosto = new JTextField();
		textCosto.setColumns(10);
		textCosto.setBounds(133, 132, 152, 20);
		getContentPane().add(textCosto);
		
		textLugar = new JTextField();
		textLugar.setColumns(10);
		textLugar.setBounds(133, 157, 152, 20);
		getContentPane().add(textLugar);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(133, 182, 152, 20);
		getContentPane().add(textFecha);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(33, 223, 105, 21);
		this.getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yo.setVisible(false);
				cbEntrenador.setSelectedIndex(-1);
				textNombre.setText(null);
				textDescripcion.setText(null);
				textDuracion.setText(null);
				textCosto.setText(null);
				textLugar.setText(null);
				textFecha.setText(null);
			}
		});
		btnCancelar.setBounds(158, 223, 105, 21);
		this.getContentPane().add(btnCancelar);
	}	
}