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

public class principal {

	private JFrame frmAirelibre;
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
		IfAlta_Usuario.setBounds(133, 64, 516, 352);
		IfAlta_Usuario.setClosable(true);
		IfAlta_Usuario.setIconifiable(true);
		IfAlta_Usuario.setMaximizable(true);
		frmAirelibre.getContentPane().add(IfAlta_Usuario);
		IfAlta_Usuario.getContentPane().setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setBounds(151, 178, 21, 21);
		IfAlta_Usuario.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.setBounds(151, 204, 21, 21);
		IfAlta_Usuario.getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(60, 58, 45, 13);
		IfAlta_Usuario.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(60, 89, 45, 13);
		IfAlta_Usuario.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(60, 123, 45, 13);
		IfAlta_Usuario.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setBounds(60, 157, 45, 13);
		IfAlta_Usuario.getContentPane().add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setBounds(147, 55, 96, 19);
		IfAlta_Usuario.getContentPane().add(textField);
		textField.setColumns(10);
		
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
