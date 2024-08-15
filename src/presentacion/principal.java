package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class principal {

	private JFrame frmAirelibre;
	private JTextField textNickname;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textEmail;
	private JTextField textFecha;
	private JPasswordField passwordContrasena;
	private JTextField textDisciplina;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal window = new principal();
					window.frmAirelibre.setVisible(true);
					window.frmAirelibre.setSize(1200, 600);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAirelibre = new JFrame();
		frmAirelibre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAirelibre.setTitle("AireLibre");
		frmAirelibre.getContentPane().setLayout(null);
		
		JInternalFrame IfAlta_Usuario = new JInternalFrame("Alta Usuario");
		IfAlta_Usuario.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		IfAlta_Usuario.setBounds(167, 59, 526, 281);
		IfAlta_Usuario.setIconifiable(true);
		IfAlta_Usuario.setMaximizable(true);
		frmAirelibre.getContentPane().add(IfAlta_Usuario);
		IfAlta_Usuario.getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(10, 14, 63, 13);
		IfAlta_Usuario.getContentPane().add(lblNickname);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 75, 63, 13);
		IfAlta_Usuario.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 109, 63, 13);
		IfAlta_Usuario.getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 143, 63, 13);
		IfAlta_Usuario.getContentPane().add(lblEmail);
		
		textNickname = new JTextField();
		textNickname.setBounds(125, 14, 96, 19);
		IfAlta_Usuario.getContentPane().add(textNickname);
		textNickname.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(270, 219, 105, 21);
		IfAlta_Usuario.getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(395, 219, 105, 21);
		IfAlta_Usuario.getContentPane().add(btnCancelar);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(125, 74, 96, 19);
		IfAlta_Usuario.getContentPane().add(textNombre);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(125, 108, 96, 19);
		IfAlta_Usuario.getContentPane().add(textApellido);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(125, 139, 96, 19);
		IfAlta_Usuario.getContentPane().add(textEmail);
		
		JLabel lblFecha = new JLabel("Fecha de Nacimiento");
		lblFecha.setBounds(10, 173, 105, 13);
		IfAlta_Usuario.getContentPane().add(lblFecha);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(125, 169, 96, 19);
		IfAlta_Usuario.getContentPane().add(textFecha);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setBounds(10, 47, 63, 13);
		IfAlta_Usuario.getContentPane().add(lblContrasena);
		
		passwordContrasena = new JPasswordField();
		passwordContrasena.setBounds(125, 43, 96, 20);
		IfAlta_Usuario.getContentPane().add(passwordContrasena);
		
		JPanel panelDeposrtista = new JPanel();
		FlowLayout fl_panelDeposrtista = (FlowLayout) panelDeposrtista.getLayout();
		fl_panelDeposrtista.setAlignment(FlowLayout.LEFT);
		fl_panelDeposrtista.setAlignOnBaseline(true);
		panelDeposrtista.setBounds(259, 55, 233, 33);
		IfAlta_Usuario.getContentPane().add(panelDeposrtista);
		
		JCheckBox chckbxEsProfesioanl = new JCheckBox("Profesional");
		panelDeposrtista.add(chckbxEsProfesioanl);
		
		JRadioButton rdbtnDeportista = new JRadioButton("Deportista");
		rdbtnDeportista.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnDeportista.setBounds(259, 37, 85, 21);
		IfAlta_Usuario.getContentPane().add(rdbtnDeportista);
		
		JRadioButton rdbtnEntrenador = new JRadioButton("Entrenador");
		rdbtnEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnEntrenador.setBounds(259, 105, 85, 21);
		IfAlta_Usuario.getContentPane().add(rdbtnEntrenador);
		
		JPanel panelEntrenador = new JPanel();
		panelEntrenador.setBounds(259, 125, 233, 55);
		IfAlta_Usuario.getContentPane().add(panelEntrenador);
		panelEntrenador.setLayout(null);
		
		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setBounds(10, 5, 68, 14);
		panelEntrenador.add(lblDisciplina);
		
		textDisciplina = new JTextField();
		textDisciplina.setColumns(10);
		textDisciplina.setBounds(88, 2, 135, 19);
		panelEntrenador.add(textDisciplina);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(88, 32, 135, 19);
		panelEntrenador.add(textField);
		
		JLabel lblWeb = new JLabel("Pagina Web");
		lblWeb.setBounds(10, 35, 68, 14);
		panelEntrenador.add(lblWeb);
		
		JMenuBar menuBar = new JMenuBar();
		frmAirelibre.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Usuario");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAltaUsuario = new JMenuItem("Alta Usuario");
		 mntmAltaUsuario.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Muestro el InternalFrame para registrar un usuario
	            	IfAlta_Usuario.setVisible(true);
	            }
	        });
		mnNewMenu.add(mntmAltaUsuario);
		
		
		JMenuItem mntmConsultaUsuario = new JMenuItem("Consulta Usuario");
		mnNewMenu.add(mntmConsultaUsuario);
		
		JMenuItem mntmModificarUsuario = new JMenuItem("Modificar Usuario");
		mnNewMenu.add(mntmModificarUsuario);
		
		JMenu mnNewMenu_1 = new JMenu("Actividad");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmAltaActividad = new JMenuItem("Alta Actividad");
		mnNewMenu_1.add(mntmAltaActividad);
		
		JMenuItem mntmConsultaActividad = new JMenuItem("Consulta Actividad");
		mnNewMenu_1.add(mntmConsultaActividad);
		
		JMenuItem mntmModificarActividad = new JMenuItem("Modificar Actividad");
		mnNewMenu_1.add(mntmModificarActividad);
		
		JMenuItem mntmRankingActividad = new JMenuItem("Ranking Actividad");
		mnNewMenu_1.add(mntmRankingActividad);
		
		JMenu mnNewMenu_2 = new JMenu("Clase e Inscrip");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmAltaClase = new JMenuItem("Alta Clase");
		mnNewMenu_2.add(mntmAltaClase);
		
		JMenuItem mntmConsultaClase = new JMenuItem("Consulta Clase");
		mnNewMenu_2.add(mntmConsultaClase);
		
		JMenuItem mntmAltaInscripcion = new JMenuItem("Alta Inscripcion");
		mnNewMenu_2.add(mntmAltaInscripcion);
		
		JMenuItem mntmConsultaInscripcion = new JMenuItem("Consulta Inscripcion");
		mnNewMenu_2.add(mntmConsultaInscripcion);
		IfAlta_Usuario.setVisible(false);
	}
}
