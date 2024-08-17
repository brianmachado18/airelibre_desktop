package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.Choice;
import java.awt.Component;
import java.awt.List;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;

public class principal {

	private JFrame frmAirelibre;
	private JTextField textNickname;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textEmail;
	private JTextField textFecha;
	private JPasswordField passwordContrasena;
	private JTextField textDisciplina;
	private JTextField textWeb;
	private JTextField textNombreConsulta;
	private JTextField textApellidoConsulta;
	private JTextField textEmailConsulta;
	private JTextField textFechaConsulta;
	private JTextField textDisciplinaConsulta;
	private JTextField textWebConsulta;

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
		
		//=== FRAME AIRELIBRE ==============================================================================
		frmAirelibre = new JFrame();
		frmAirelibre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAirelibre.setTitle("AireLibre");
		frmAirelibre.getContentPane().setLayout(null);
		
		JInternalFrame IFAltaUsuario = new JInternalFrame("");
		IFAltaUsuario.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		IFAltaUsuario.setBounds(10, 11, 524, 257);
		frmAirelibre.getContentPane().add(IFAltaUsuario);
		IFAltaUsuario.getContentPane().setLayout(null);	
		IFAltaUsuario.setVisible(false);

		JInternalFrame IFConsultaUsuario = new JInternalFrame("Consulta Usuario");
		IFConsultaUsuario.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		IFConsultaUsuario.setBounds(47, 40, 658, 362);
		frmAirelibre.getContentPane().add(IFConsultaUsuario);
		IFConsultaUsuario.getContentPane().setLayout(null);
		IFConsultaUsuario.setVisible(false);
		
		JInternalFrame IFAltaActividad = new JInternalFrame("Alta Actividad");
		IFAltaActividad.setClosable(true);
		IFAltaActividad.setBounds(758, 76, 249, 214);
		frmAirelibre.getContentPane().add(IFAltaActividad);
		IFAltaActividad.setVisible(false);
		
		//=== MENU BAR =====================================================================================
		JMenuBar menuBar = new JMenuBar();
		frmAirelibre.setJMenuBar(menuBar);
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		JMenuItem mntmAltaUsuario = new JMenuItem("Alta Usuario");
		mnUsuario.add(mntmAltaUsuario);
		
		JMenuItem mntmConsultaUsuario = new JMenuItem("Consulta Usuario");
		mnUsuario.add(mntmConsultaUsuario);
		
		JMenuItem mntmModificarUsuario = new JMenuItem("Modificar Usuario");
		mnUsuario.add(mntmModificarUsuario);
		
		JMenu mnActividad = new JMenu("Actividad");
		menuBar.add(mnActividad);
		
		JMenuItem mntmAltaActividad = new JMenuItem("Alta Actividad");
		mnActividad.add(mntmAltaActividad);
		
		JMenuItem mntmConsultaActividad = new JMenuItem("Consulta Actividad");
		mnActividad.add(mntmConsultaActividad);
		
		JMenuItem mntmModificarActividad = new JMenuItem("Modificar Actividad");
		mnActividad.add(mntmModificarActividad);
		
		JMenuItem mntmRankingActividad = new JMenuItem("Ranking Actividad");
		mnActividad.add(mntmRankingActividad);
		
		JMenu mnClasesInscrip = new JMenu("Clase e Inscrip");
		menuBar.add(mnClasesInscrip);
		
		JMenuItem mntmAltaClase = new JMenuItem("Alta Clase");
		mnClasesInscrip.add(mntmAltaClase);
		
		JMenuItem mntmConsultaClase = new JMenuItem("Consulta Clase");
		mnClasesInscrip.add(mntmConsultaClase);
		
		JMenuItem mntmAltaInscripcion = new JMenuItem("Alta Inscripcion");
		mnClasesInscrip.add(mntmAltaInscripcion);
		
		JMenuItem mntmConsultaInscripcion = new JMenuItem("Consulta Inscripcion");
		mnClasesInscrip.add(mntmConsultaInscripcion);
		
		//=== FRAME ALTA Y MODIFICACION USUARIO ============================================================
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(10, 14, 63, 13);
		IFAltaUsuario.getContentPane().add(lblNickname);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setBounds(10, 47, 63, 13);
		IFAltaUsuario.getContentPane().add(lblContrasena);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 72, 63, 13);
		IFAltaUsuario.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 106, 63, 13);
		IFAltaUsuario.getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 140, 63, 13);
		IFAltaUsuario.getContentPane().add(lblEmail);
		
		JLabel lblFecha = new JLabel("Fecha de Nacimiento");
		lblFecha.setBounds(10, 170, 105, 13);
		IFAltaUsuario.getContentPane().add(lblFecha);
		
		textNickname = new JTextField();
		textNickname.setBounds(125, 14, 96, 19);
		IFAltaUsuario.getContentPane().add(textNickname);
		
		passwordContrasena = new JPasswordField();
		passwordContrasena.setBounds(125, 43, 96, 20);
		IFAltaUsuario.getContentPane().add(passwordContrasena);
		textNickname.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(125, 71, 96, 19);
		IFAltaUsuario.getContentPane().add(textNombre);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(125, 105, 96, 19);
		IFAltaUsuario.getContentPane().add(textApellido);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(125, 136, 96, 19);
		IFAltaUsuario.getContentPane().add(textEmail);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(125, 169, 96, 19);
		IFAltaUsuario.getContentPane().add(textFecha);
		
		JPanel panelDeposrtista = new JPanel();
		FlowLayout fl_panelDeposrtista = (FlowLayout) panelDeposrtista.getLayout();
		fl_panelDeposrtista.setAlignOnBaseline(true);
		panelDeposrtista.setBounds(253, 32, 233, 33);
		IFAltaUsuario.getContentPane().add(panelDeposrtista);
		
		JCheckBox chckbxEsProfesioanl = new JCheckBox("Profesional");
		chckbxEsProfesioanl.setEnabled(false);
		panelDeposrtista.add(chckbxEsProfesioanl);
		
		JPanel panelEntrenador = new JPanel();
		panelEntrenador.setBounds(253, 102, 233, 55);
		IFAltaUsuario.getContentPane().add(panelEntrenador);
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
		IFAltaUsuario.getContentPane().add(rdbtnDeportista);
		
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
		IFAltaUsuario.getContentPane().add(rdbtnEntrenador);
		
		//Grupo de botones para que solo se seleccione uno
		ButtonGroup rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnEntrenador);
		rdbtnGroup.add(rdbtnDeportista);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(278, 195, 105, 21);
		IFAltaUsuario.getContentPane().add(btnConfirmar);
		
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
				IFAltaUsuario.setVisible(false);
			}
		});
		btnCancelar.setBounds(393, 195, 105, 21);
		IFAltaUsuario.getContentPane().add(btnCancelar);
		
		//=== FRAME CONSULTA USUARIO ===========================================================================
		Label lblNicknameConsulta = new Label("Nickname");
		lblNicknameConsulta.setBounds(157, 21, 62, 22);
		IFConsultaUsuario.getContentPane().add(lblNicknameConsulta);
		
		TextField textNicknameConsulta = new TextField();
		textNicknameConsulta.setBounds(225, 21, 95, 22);
		IFConsultaUsuario.getContentPane().add(textNicknameConsulta);
		
		Button btmBuscarConsulta = new Button("Buscar");
		btmBuscarConsulta.setBounds(352, 21, 70, 22);
		IFConsultaUsuario.getContentPane().add(btmBuscarConsulta);
		
		textNombreConsulta = new JTextField();
		textNombreConsulta.setEditable(false);
		textNombreConsulta.setColumns(10);
		textNombreConsulta.setBounds(275, 114, 96, 19);
		IFConsultaUsuario.getContentPane().add(textNombreConsulta);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(157, 120, 63, 13);
		IFConsultaUsuario.getContentPane().add(lblNombre_1);
		
		JLabel lblApellido_1 = new JLabel("Apellido");
		lblApellido_1.setBounds(157, 148, 63, 13);
		IFConsultaUsuario.getContentPane().add(lblApellido_1);
		
		textApellidoConsulta = new JTextField();
		textApellidoConsulta.setEditable(false);
		textApellidoConsulta.setColumns(10);
		textApellidoConsulta.setBounds(275, 144, 96, 19);
		IFConsultaUsuario.getContentPane().add(textApellidoConsulta);
		
		textEmailConsulta = new JTextField();
		textEmailConsulta.setEditable(false);
		textEmailConsulta.setColumns(10);
		textEmailConsulta.setBounds(275, 174, 96, 19);
		IFConsultaUsuario.getContentPane().add(textEmailConsulta);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setBounds(157, 178, 63, 13);
		IFConsultaUsuario.getContentPane().add(lblEmail_1);
		
		JLabel lblFecha_1 = new JLabel("Fecha de Nacimiento");
		lblFecha_1.setBounds(160, 208, 105, 13);
		IFConsultaUsuario.getContentPane().add(lblFecha_1);
		
		textFechaConsulta = new JTextField();
		textFechaConsulta.setEditable(false);
		textFechaConsulta.setColumns(10);
		textFechaConsulta.setBounds(275, 204, 96, 19);
		IFConsultaUsuario.getContentPane().add(textFechaConsulta);
		
		JRadioButton rdbtnEntrenadorConsulta = new JRadioButton("Entrenador");
		rdbtnEntrenadorConsulta.setEnabled(false);
		rdbtnEntrenadorConsulta.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnEntrenadorConsulta.setBounds(403, 143, 233, 21);
		IFConsultaUsuario.getContentPane().add(rdbtnEntrenadorConsulta);
		
		JRadioButton rdbtnDeportistaConsulta = new JRadioButton("Deportista");
		rdbtnDeportistaConsulta.setEnabled(false);
		rdbtnDeportistaConsulta.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnDeportistaConsulta.setBounds(403, 80, 233, 21);
		IFConsultaUsuario.getContentPane().add(rdbtnDeportistaConsulta);
		
		JPanel panelDeposrtista_1 = new JPanel();
		panelDeposrtista_1.setBounds(403, 100, 233, 33);
		IFConsultaUsuario.getContentPane().add(panelDeposrtista_1);
		
		JCheckBox chckbxEsProfesioanlConsulta = new JCheckBox("Profesional");
		chckbxEsProfesioanlConsulta.setEnabled(false);
		panelDeposrtista_1.add(chckbxEsProfesioanlConsulta);
		
		JPanel panelEntrenador_1 = new JPanel();
		panelEntrenador_1.setLayout(null);
		panelEntrenador_1.setBounds(403, 169, 233, 55);
		IFConsultaUsuario.getContentPane().add(panelEntrenador_1);
		
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
				IFConsultaUsuario.setVisible(false);
			}
		});
		btnCancelarConsulta.setBounds(527, 301, 105, 21);
		IFConsultaUsuario.getContentPane().add(btnCancelarConsulta);

		//=== LISTA CON USUARIOS ===================================================================
		List listConsultaUsuario = new List();
		listConsultaUsuario.setBounds(10, 10, 110, 312);
		IFConsultaUsuario.getContentPane().add(listConsultaUsuario);
		
		//=== FRAME X ==============================================================================
		

		
		//=== EVENTOS MENU =========================================================================
		mntmAltaUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// Posible solucion para reutilizar el frame
            	IFAltaUsuario.setTitle("Alta Usuario");
            	IFAltaUsuario.setClosable(false);
            	btnConfirmar.setVisible(true);
            	btnCancelar.setVisible(true);
                // Muestro el InternalFrame para registrar un usuario
            	IFAltaUsuario.setVisible(true);
            }
		});
		
		mntmModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Posible solucion para reutilizar el frame
				IFAltaUsuario.setTitle("Modificar Usuario: [NICKNAME]");
				IFAltaUsuario.setClosable(false);
            	btnConfirmar.setVisible(true);
            	btnCancelar.setVisible(true);
                // Muestro el InternalFrame para modificar un usuario
            	IFAltaUsuario.setVisible(true);
			}
		});

		mntmConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestro el InternalFrame para registrar una actividad
				IFConsultaUsuario.setVisible(true);
			}
		});

		mntmAltaActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestro el InternalFrame para registrar un usuario
				IFAltaActividad.setVisible(true);
			}
		});
		
		//==========================================================================================
	}
}