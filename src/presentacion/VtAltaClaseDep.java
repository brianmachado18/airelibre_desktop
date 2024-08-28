package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class VtAltaClaseDep extends JInternalFrame{
	JButton btnCancelar;
	JInternalFrame yo = this;
	private JTextField textNombre;
	private JTextField textFecha;
	private JTextField textHora;
	private JTextField textLugar;
	private JTextField textCupos;
	private JTextField textFechaAlta;
	public VtAltaClaseDep() {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(47, 40, 298, 270);
		this.getContentPane().setLayout(null);
		this.setTitle("Alta Clase");
		this.setVisible(false);
		this.setClosable(false);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yo.setVisible(false);
			}
		});
		btnCancelar.setBounds(167, 208, 105, 21);
		this.getContentPane().add(btnCancelar);
		
		JLabel lblActividad = new JLabel("Actividad");
		lblActividad.setBounds(10, 21, 105, 14);
		getContentPane().add(lblActividad);
		
		JComboBox cbActividad = new JComboBox();
		cbActividad.setBounds(125, 17, 147, 22);
		getContentPane().add(cbActividad);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 46, 105, 14);
		getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(125, 43, 147, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 71, 105, 14);
		getContentPane().add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(10, 96, 105, 14);
		getContentPane().add(lblHora);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(10, 121, 105, 14);
		getContentPane().add(lblLugar);
		
		JLabel lblCupos = new JLabel("Cupos");
		lblCupos.setBounds(10, 146, 105, 14);
		getContentPane().add(lblCupos);
		
		JLabel lblFechaAlta = new JLabel("Fecha de alta");
		lblFechaAlta.setBounds(10, 171, 105, 14);
		getContentPane().add(lblFechaAlta);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(125, 68, 147, 20);
		getContentPane().add(textFecha);
		
		textHora = new JTextField();
		textHora.setColumns(10);
		textHora.setBounds(125, 93, 147, 20);
		getContentPane().add(textHora);
		
		textLugar = new JTextField();
		textLugar.setColumns(10);
		textLugar.setBounds(125, 118, 147, 20);
		getContentPane().add(textLugar);
		
		textCupos = new JTextField();
		textCupos.setColumns(10);
		textCupos.setBounds(125, 143, 147, 20);
		getContentPane().add(textCupos);
		
		textFechaAlta = new JTextField();
		textFechaAlta.setColumns(10);
		textFechaAlta.setBounds(125, 168, 147, 20);
		getContentPane().add(textFechaAlta);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(52, 207, 105, 21);
		getContentPane().add(btnConfirmar);
		
	}	
}