package presentacion;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VtAltaUsuario extends JInternalFrame{
	private JTextField textNickname;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textEmail;
	private JTextField textFecha;
	private JPasswordField passwordContrasena;
	private JTextField textDisciplina;
	private JTextField textWeb;
	JInternalFrame yo = this;
	public VtAltaUsuario() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(10, 11, 524, 257);
		this.getContentPane().setLayout(null);	
		this.setTitle("Alta Usuario");
		this.setClosable(false);

		//============JLABELS ALTA============================
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(10, 14, 63, 13);
		this.getContentPane().add(lblNickname);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setBounds(10, 47, 63, 13);
		this.getContentPane().add(lblContrasena);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 72, 63, 13);
		this.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 106, 63, 13);
		this.getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 140, 63, 13);
		this.getContentPane().add(lblEmail);
		
		JLabel lblFecha = new JLabel("Fecha de Nacimiento");
		lblFecha.setBounds(10, 170, 105, 13);
		this.getContentPane().add(lblFecha);
		//==================================================================
		
		//=========CAMPOS DE TEXTO ALTA===========================
		textNickname = new JTextField();
		textNickname.setBounds(125, 14, 96, 19);
		this.getContentPane().add(textNickname);
		
		passwordContrasena = new JPasswordField();
		passwordContrasena.setBounds(125, 43, 96, 20);
		this.getContentPane().add(passwordContrasena);
		textNickname.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(125, 71, 96, 19);
		this.getContentPane().add(textNombre);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(125, 105, 96, 19);
		this.getContentPane().add(textApellido);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(125, 136, 96, 19);
		this.getContentPane().add(textEmail);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(125, 169, 96, 19);
		this.getContentPane().add(textFecha);
		//==============================================
		
		
		JPanel panelDeposrtista = new JPanel();
		FlowLayout fl_panelDeposrtista = (FlowLayout) panelDeposrtista.getLayout();
		fl_panelDeposrtista.setAlignOnBaseline(true);
		panelDeposrtista.setBounds(253, 32, 233, 33);
		this.getContentPane().add(panelDeposrtista);
		
		JCheckBox chckbxEsProfesioanl = new JCheckBox("Profesional");
		chckbxEsProfesioanl.setEnabled(false);
		panelDeposrtista.add(chckbxEsProfesioanl);
		
		JPanel panelEntrenador = new JPanel();
		panelEntrenador.setBounds(253, 102, 233, 55);
		this.getContentPane().add(panelEntrenador);
		panelEntrenador.setLayout(null);
		
		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setEnabled(false);
		lblDisciplina.setBounds(10, 5, 68, 14);
		panelEntrenador.add(lblDisciplina);
		
		JLabel lblWeb = new JLabel("Pagina Web");
		lblWeb.setEnabled(false);
		lblWeb.setBounds(10, 35, 68, 14);
		panelEntrenador.add(lblWeb);
		
		textDisciplina = new JTextField();
		textDisciplina.setColumns(10);
		textDisciplina.setBounds(88, 2, 135, 19);
		textDisciplina.setEnabled(false);
		panelEntrenador.add(textDisciplina);
		
		textWeb = new JTextField();
		textWeb.setColumns(10);
		textWeb.setBounds(88, 32, 135, 19);
		textWeb.setEnabled(false);
		panelEntrenador.add(textWeb);
		
		JRadioButton rdbtnDeportista = new JRadioButton("Deportista");
		rdbtnDeportista.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (rdbtnDeportista.isSelected()) {
					chckbxEsProfesioanl.setEnabled(true);
				} else {
					chckbxEsProfesioanl.setEnabled(false);
				}
			}
		});
		rdbtnDeportista.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnDeportista.setBounds(253, 14, 233, 21);
		this.getContentPane().add(rdbtnDeportista);
		
		JRadioButton rdbtnEntrenador = new JRadioButton("Entrenador");
		rdbtnEntrenador.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (rdbtnEntrenador.isSelected()) {
					lblDisciplina.setEnabled(true);
					textDisciplina.setEnabled(true);
					lblWeb.setEnabled(true);
					textWeb.setEnabled(true);
				}
				else {
					lblDisciplina.setEnabled(false);
					textDisciplina.setEnabled(false);
					lblWeb.setEnabled(false);
					textWeb.setEnabled(false);
				}
			}
		});
		rdbtnEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnEntrenador.setBounds(253, 82, 233, 21);
		this.getContentPane().add(rdbtnEntrenador);
		
		//Grupo de botones para que solo se seleccione uno
		ButtonGroup rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnEntrenador);
		rdbtnGroup.add(rdbtnDeportista);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(278, 195, 105, 21);
		this.getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNickname.setText(null);
				passwordContrasena.setText(null);
				textNombre.setText(null);
				textApellido.setText(null);
				textEmail.setText(null);
				textFecha.setText(null);
				textDisciplina.setText(null);
				textWeb.setText(null);
				chckbxEsProfesioanl.setSelected(false);
				rdbtnGroup.clearSelection();
				yo.setVisible(false);
			}
		});
		btnCancelar.setBounds(393, 195, 105, 21);
		this.getContentPane().add(btnCancelar);
		btnConfirmar.setVisible(true);
		btnCancelar.setVisible(true);
	}	
}
