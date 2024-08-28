package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VtInscClaseDep extends JInternalFrame{
	JButton btnCancelar;
	JInternalFrame yo = this;
	private JTextField textFechaAlta;
	private JTextField textCupos;
	private JTextField textLugar;
	private JTextField textHora;
	private JTextField textFecha;
	private JTextField textCantidadInscrip;
	private JTextField textFechaInscrip;
	public VtInscClaseDep() {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(47, 40, 675, 343);
		this.getContentPane().setLayout(null);
		this.setTitle("Inscripcion");
		this.setVisible(false);
		this.setClosable(false);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yo.setVisible(false);
			}
		});
		btnCancelar.setBounds(548, 282, 100, 21);
		this.getContentPane().add(btnCancelar);
		
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
		
		JList listDeportistas = new JList();
		listDeportistas.setBounds(442, 36, 206, 138);
		getContentPane().add(listDeportistas);
		
		JLabel lblDeportista = new JLabel("Deportista");
		lblDeportista.setBounds(442, 11, 206, 14);
		getContentPane().add(lblDeportista);
		
		JLabel lblCantidadInscrip = new JLabel("Cantidad");
		lblCantidadInscrip.setBounds(441, 185, 97, 14);
		getContentPane().add(lblCantidadInscrip);
		
		JLabel lblFechaInscrip = new JLabel("Fecha");
		lblFechaInscrip.setBounds(442, 210, 96, 14);
		getContentPane().add(lblFechaInscrip);
		
		textCantidadInscrip = new JTextField();
		textCantidadInscrip.setBounds(548, 182, 100, 20);
		getContentPane().add(textCantidadInscrip);
		textCantidadInscrip.setColumns(10);
		
		textFechaInscrip = new JTextField();
		textFechaInscrip.setColumns(10);
		textFechaInscrip.setBounds(548, 207, 100, 20);
		getContentPane().add(textFechaInscrip);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(438, 282, 100, 21);
		getContentPane().add(btnConfirmar);
	}
}