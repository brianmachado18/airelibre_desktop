package presentacion;

import java.awt.Button;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VtConsUsuario extends JInternalFrame{
	private JTextField textNombreConsulta;
	private JTextField textApellidoConsulta;
	private JTextField textEmailConsulta;
	private JTextField textFechaConsulta;
	private JTextField textDisciplinaConsulta;
	private JTextField textWebConsulta;
	JInternalFrame yo = this;

	public VtConsUsuario() {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(47, 40, 658, 362);
		this.getContentPane().setLayout(null);
		this.setTitle("Consulta Usuario");
		this.setVisible(false);
		this.setClosable(false);
		
		Label lblNicknameConsulta = new Label("Nickname");
		lblNicknameConsulta.setBounds(157, 21, 62, 22);
		this.getContentPane().add(lblNicknameConsulta);
		
		TextField textNicknameConsulta = new TextField();
		textNicknameConsulta.setBounds(225, 21, 95, 22);
		this.getContentPane().add(textNicknameConsulta);
		
		Button btmBuscarConsulta = new Button("Buscar");
		btmBuscarConsulta.setBounds(352, 21, 70, 22);
		this.getContentPane().add(btmBuscarConsulta);
		
		textNombreConsulta = new JTextField();
		textNombreConsulta.setEditable(false);
		textNombreConsulta.setColumns(10);
		textNombreConsulta.setBounds(275, 114, 96, 19);
		this.getContentPane().add(textNombreConsulta);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(157, 120, 63, 13);
		this.getContentPane().add(lblNombre_1);
		
		JLabel lblApellido_1 = new JLabel("Apellido");
		lblApellido_1.setBounds(157, 148, 63, 13);
		this.getContentPane().add(lblApellido_1);
		
		textApellidoConsulta = new JTextField();
		textApellidoConsulta.setEditable(false);
		textApellidoConsulta.setColumns(10);
		textApellidoConsulta.setBounds(275, 144, 96, 19);
		this.getContentPane().add(textApellidoConsulta);
		
		textEmailConsulta = new JTextField();
		textEmailConsulta.setEditable(false);
		textEmailConsulta.setColumns(10);
		textEmailConsulta.setBounds(275, 174, 96, 19);
		this.getContentPane().add(textEmailConsulta);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setBounds(157, 178, 63, 13);
		this.getContentPane().add(lblEmail_1);
		
		JLabel lblFecha_1 = new JLabel("Fecha de Nacimiento");
		lblFecha_1.setBounds(160, 208, 105, 13);
		this.getContentPane().add(lblFecha_1);
		
		textFechaConsulta = new JTextField();
		textFechaConsulta.setEditable(false);
		textFechaConsulta.setColumns(10);
		textFechaConsulta.setBounds(275, 204, 96, 19);
		this.getContentPane().add(textFechaConsulta);
		
		JRadioButton rdbtnEntrenadorConsulta = new JRadioButton("Entrenador");
		rdbtnEntrenadorConsulta.setEnabled(false);
		rdbtnEntrenadorConsulta.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnEntrenadorConsulta.setBounds(403, 143, 233, 21);
		this.getContentPane().add(rdbtnEntrenadorConsulta);
		
		JRadioButton rdbtnDeportistaConsulta = new JRadioButton("Deportista");
		rdbtnDeportistaConsulta.setEnabled(false);
		rdbtnDeportistaConsulta.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnDeportistaConsulta.setBounds(403, 80, 233, 21);
		this.getContentPane().add(rdbtnDeportistaConsulta);
		
		JPanel panelDeposrtista_1 = new JPanel();
		panelDeposrtista_1.setBounds(403, 100, 233, 33);
		this.getContentPane().add(panelDeposrtista_1);
		
		JCheckBox chckbxEsProfesioanlConsulta = new JCheckBox("Profesional");
		chckbxEsProfesioanlConsulta.setEnabled(false);
		panelDeposrtista_1.add(chckbxEsProfesioanlConsulta);
		
		JPanel panelEntrenador_1 = new JPanel();
		panelEntrenador_1.setLayout(null);
		panelEntrenador_1.setBounds(403, 169, 233, 55);
		this.getContentPane().add(panelEntrenador_1);
		
		JLabel lblDisciplina_1 = new JLabel("Disciplina");
		lblDisciplina_1.setEnabled(false);
		lblDisciplina_1.setBounds(10, 5, 68, 14);
		panelEntrenador_1.add(lblDisciplina_1);
		
		JLabel lblWeb_1 = new JLabel("Pagina Web");
		lblWeb_1.setEnabled(false);
		lblWeb_1.setBounds(10, 35, 68, 14);
		panelEntrenador_1.add(lblWeb_1);
		
		textDisciplinaConsulta = new JTextField();
		textDisciplinaConsulta.setEnabled(false);
		textDisciplinaConsulta.setColumns(10);
		textDisciplinaConsulta.setBounds(88, 2, 135, 19);
		panelEntrenador_1.add(textDisciplinaConsulta);
		
		textWebConsulta = new JTextField();
		textWebConsulta.setEnabled(false);
		textWebConsulta.setColumns(10);
		textWebConsulta.setBounds(88, 32, 135, 19);
		panelEntrenador_1.add(textWebConsulta);
		
		JButton btnCancelarConsulta = new JButton("Cancelar");
		btnCancelarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNicknameConsulta.setText(null);
				yo.setVisible(false);
			}
		});
		btnCancelarConsulta.setBounds(527, 301, 105, 21);
		this.getContentPane().add(btnCancelarConsulta);
		
		List listConsultaUsuario = new List();
		listConsultaUsuario.setBounds(10, 10, 110, 312);
		this.getContentPane().add(listConsultaUsuario);
	}	
}