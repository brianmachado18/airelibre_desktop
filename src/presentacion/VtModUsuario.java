package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import datatype.DtDeportista;
import datatype.DtEntrenador;
import excepciones.PersistenciaException;
import logica.IControladorUsuario;
import javax.swing.JPasswordField;

public class VtModUsuario extends JInternalFrame{
	private JTextField textDisciplina;
	private JTextField textWebConsulta;
	private JRadioButton rdbtnEntrenador;
	private JRadioButton rdbtnDeportista;
	private JCheckBox chckbxEsProfesioanl;
	private JList<String> listUsuarios;
	private IControladorUsuario iControladorUsuario;
	private JTextField textNickname;
	JButton btnCerrar;
	private JInternalFrame yo = this;
	private VtPrincipal principal;
	private JTextField textNombre;
	private JTextField textApellido;
	private JPanel panelCampos;
	private JTextField textEmail;
	private JTextField textFecha;
	private JPasswordField passwordField;
	private JCheckBox chckbxContrasena;
	private JButton btnBuscar;
	public VtModUsuario(IControladorUsuario i, VtPrincipal VtPrincipal) {
		
		principal = VtPrincipal;
		principal.bajarFrameActual();
		//Inicio el controlador usuario
		iControladorUsuario = i;
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(700, 298);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.decode("#cbdad5"));
		setTitle("Modificar Usuario");
		setVisible(false);
		principal.setFrameActual(yo);
		
		rdbtnEntrenador = new JRadioButton("Entrenador");
		rdbtnEntrenador.setEnabled(false);
		rdbtnEntrenador.setBackground(new Color(203, 218, 213));
		rdbtnEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnEntrenador.setBounds(456, 125, 233, 21);
		this.getContentPane().add(rdbtnEntrenador);
		
		rdbtnDeportista = new JRadioButton("Deportista");
		rdbtnDeportista.setEnabled(false);
		rdbtnDeportista.setBackground(new Color(203, 218, 213));
		rdbtnDeportista.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnDeportista.setBounds(456, 62, 233, 21);
		this.getContentPane().add(rdbtnDeportista);
		
		JPanel panelDeposrtista = new JPanel();
		panelDeposrtista.setBackground(new Color(203, 218, 213));
		panelDeposrtista.setBounds(456, 82, 233, 33);
		this.getContentPane().add(panelDeposrtista);
		
		chckbxEsProfesioanl = new JCheckBox("Profesional");
		chckbxEsProfesioanl.setEnabled(false);
		chckbxEsProfesioanl.setBackground(new Color(203, 218, 213));
		panelDeposrtista.add(chckbxEsProfesioanl);
		
		JPanel panelEntrenador = new JPanel();
		panelEntrenador.setBackground(new Color(203, 218, 213));
		panelEntrenador.setLayout(null);
		panelEntrenador.setBounds(456, 151, 233, 55);
		this.getContentPane().add(panelEntrenador);
		
		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setBounds(10, 5, 68, 14);
		panelEntrenador.add(lblDisciplina);
		
		JLabel lblWeb = new JLabel("Pagina Web");
		lblWeb.setBounds(10, 35, 68, 14);
		panelEntrenador.add(lblWeb);
		
		textDisciplina = new JTextField();
		textDisciplina.setEnabled(false);
		textDisciplina.setColumns(10);
		textDisciplina.setBounds(88, 2, 135, 19);
		panelEntrenador.add(textDisciplina);
		
		textWebConsulta = new JTextField();
		textWebConsulta.setEnabled(false);
		textWebConsulta.setColumns(10);
		textWebConsulta.setBounds(88, 32, 135, 19);
		panelEntrenador.add(textWebConsulta);
		
		JButton btnCancelar = new JButton("Salir");
		btnCancelar.setBounds(569, 235, 105, 21);
		this.getContentPane().add(btnCancelar);
		
		listUsuarios = new JList<String>();
		listUsuarios.setBounds(10, 11, 137, 246);
		getContentPane().add(listUsuarios);
		
		textNickname = new JTextField();
		textNickname.setColumns(10);
		textNickname.setBounds(238, 21, 96, 19);
		getContentPane().add(textNickname);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(456, 235, 105, 21);
		getContentPane().add(btnModificar);
		
		panelCampos = new JPanel();
		panelCampos.setBounds(167, 58, 271, 200);
		getContentPane().add(panelCampos);
		panelCampos.setLayout(null);
		panelCampos.setBackground(Color.decode("#cbdad5"));
		
		textNombre = new JTextField();
		textNombre.setEnabled(false);
		textNombre.setBounds(126, 65, 130, 20);
		panelCampos.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setEnabled(false);
		textApellido.setBounds(126, 96, 130, 20);
		panelCampos.add(textApellido);
		textApellido.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setEnabled(false);
		textEmail.setColumns(10);
		textEmail.setBounds(126, 127, 130, 20);
		panelCampos.add(textEmail);
		
		textFecha = new JTextField();
		textFecha.setEnabled(false);
		textFecha.setColumns(10);
		textFecha.setBounds(126, 158, 130, 20);
		panelCampos.add(textFecha);
		
		JLabel lblConstrasena = new JLabel("Contraseña");
		lblConstrasena.setBounds(10, 14, 106, 14);
		panelCampos.add(lblConstrasena);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 68, 106, 14);
		panelCampos.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 99, 106, 14);
		panelCampos.add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 130, 106, 14);
		panelCampos.add(lblEmail);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(10, 161, 106, 14);
		panelCampos.add(lblFechaDeNacimiento);
		
		passwordField = new JPasswordField();
		passwordField.setEnabled(false);
		passwordField.setEchoChar('*');
		passwordField.setBounds(126, 11, 130, 20);
		panelCampos.add(passwordField);
		
		chckbxContrasena = new JCheckBox("Mostrar contraseña");
		chckbxContrasena.setEnabled(false);
		chckbxContrasena.setBounds(10, 35, 246, 23);
		chckbxContrasena.setBackground(Color.decode("#cbdad5"));
		panelCampos.add(chckbxContrasena);
		
		//Grupo de botones para que solo se seleccione uno
		ButtonGroup rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnEntrenador);
		rdbtnGroup.add(rdbtnDeportista);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(359, 20, 105, 21);
		getContentPane().add(btnBuscar);
		
		//EVENTOS
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnCancelar.getText().compareTo("Salir")==0) {
					yo.dispose();
				} else {
					limpiarCampos();
					btnCancelar.setText("Salir");
				}
			}
		});
		
		addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				Vector<String> vUsuarios = new Vector<String>();
				try {
					vUsuarios = iControladorUsuario.obtenerVectorUsuarios();
				} catch (PersistenciaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!vUsuarios.isEmpty()) {
					listUsuarios.setListData(vUsuarios);
				}
			}
		});
		
		listUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textNickname.setText(listUsuarios.getSelectedValue());
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
				String nick = textNickname.getText();
				try {
					if(iControladorUsuario.usuarioExiste(nick)) {
						setCamposEnable(true);
						btnCancelar.setText("Cancelar");
						if (iControladorUsuario.esEntrenador(nick)) {
							DtEntrenador traerEntrenador = iControladorUsuario.obtenerEntrenador(nick);
							passwordField.setText(traerEntrenador.getContrasena());
							textNombre.setText(traerEntrenador.getNombre());
							textApellido.setText(traerEntrenador.getApellido());
							textEmail.setText(traerEntrenador.getMail());
							textFecha.setText(traerEntrenador.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
							rdbtnEntrenador.setSelected(true);
							textDisciplina.setText(traerEntrenador.getDisciplina());
							textWebConsulta.setText(traerEntrenador.getSitioWeb());
						} else {
							DtDeportista traerDeportista = iControladorUsuario.obtenerDeportista(nick);
							passwordField.setText(traerDeportista.getContrasena());
							textNombre.setText(traerDeportista.getNombre());
							textApellido.setText(traerDeportista.getApellido());
							textEmail.setText(traerDeportista.getMail());
							textFecha.setText(traerDeportista.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
							rdbtnDeportista.setSelected(true);
							chckbxEsProfesioanl.setSelected(traerDeportista.isEsProfesional());
						}
					} else {
						JOptionPane.showMessageDialog( textNickname, "El usuario no existe","Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} catch (PersistenciaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		chckbxContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxContrasena.isSelected()) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('*');
				}
			}
		});
		

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Validaciones y demas cosas para la modificacion
			}
		});
		
	}
	
	public void limpiarCampos() {
		passwordField.setText("");
		textNombre.setText("");
		textApellido.setText("");
		textEmail.setText("");
		textFecha.setText("");
		rdbtnDeportista.setSelected(false);
		chckbxEsProfesioanl.setSelected(false);
		rdbtnEntrenador.setSelected(false);
		textDisciplina.setText("");
		textWebConsulta.setText("");
		setCamposEnable(false);
	}
	
	public void setCamposEnable(boolean b) {
		passwordField.setEnabled(b);
		textNombre.setEnabled(b);
		textApellido.setEnabled(b);
		textEmail.setEnabled(b);
		textFecha.setEnabled(b);
		rdbtnDeportista.setEnabled(b);
		chckbxEsProfesioanl.setEnabled(b);
		rdbtnEntrenador.setEnabled(b);
		textDisciplina.setEnabled(b);
		textWebConsulta.setEnabled(b);
		chckbxContrasena.setEnabled(b);
		textNickname.setEnabled(!b);
		btnBuscar.setEnabled(!b);
	}
	
}
