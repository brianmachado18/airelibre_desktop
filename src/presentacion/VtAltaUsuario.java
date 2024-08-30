package presentacion;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import java.awt.*;
import excepciones.PersistenciaException;
import logica.ControladorUsuario;
import logica.Fabrica;
import logica.IControladorUsuario;
import persistencia.ManejarPersistenia;


public class VtAltaUsuario extends JInternalFrame{

	private JTextField textNickname;
	private JPasswordField passwordContrasena;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textEmail;
	private JTextField textFecha;
	private JCheckBox chckbxEsProfesioanl;
	private JTextField textDisciplina;
	private JTextField textWeb;
	private JRadioButton rdbtnDeportista;
	private JRadioButton rdbtnEntrenador;
	private IControladorUsuario iControladorUsuario;
	private ManejarPersistenia manejarPersistencia = new ManejarPersistenia();
	private VtPrincipal principal;
	private JInternalFrame yo = this;
	public VtAltaUsuario(IControladorUsuario i, VtPrincipal VtPrincipal) {
		principal = VtPrincipal;
		principal.bajarFrameActual();
		//Inicio el controlador usuario
		iControladorUsuario = i;
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize( 650, 370);
		getContentPane().setLayout(null);	
		setTitle("Alta Usuario");
		getContentPane().setBackground(Color.decode("#cbdad5"));
		principal.setFrameActual(yo);

		//============JLABELS ALTA============================
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(10, 18, 63, 13);
		this.getContentPane().add(lblNickname);

		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setBounds(10, 47, 63, 13);
		this.getContentPane().add(lblContrasena);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 75, 63, 13);
		this.getContentPane().add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 109, 63, 13);
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

		chckbxEsProfesioanl = new JCheckBox("Profesional");
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

		rdbtnDeportista = new JRadioButton("Deportista");
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

		rdbtnEntrenador = new JRadioButton("Entrenador");
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
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					confirmarAltaUsuario();
				} catch (PersistenciaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConfirmar.setBounds(278, 195, 105, 21);
		this.getContentPane().add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yo.dispose();
			}
		});
		btnCancelar.setBounds(393, 195, 105, 21);
		this.getContentPane().add(btnCancelar);
		btnConfirmar.setVisible(true);
		btnCancelar.setVisible(true);
	}



	private void confirmarAltaUsuario() throws PersistenciaException{
		
		//Guardo los datos en variables
		String nickname = textNickname.getText();
		String contrasena = new String(passwordContrasena.getPassword());
		String nombre = textNombre.getText();
		String apellido = textApellido.getText();
		String email = textEmail.getText();
		String fechaNacimiento = textFecha.getText();
		String tipoUsuario = "";
		boolean esProfesional = false;
		String disciplina = "";
		String web = "";
		

		//Verifico campos obligatorios 
		if (nickname.isEmpty() || contrasena.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || fechaNacimiento.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (rdbtnDeportista.isSelected()) {
			tipoUsuario = "Deportista";
			esProfesional = chckbxEsProfesioanl.isSelected();
		} else if (rdbtnEntrenador.isSelected()) {
			tipoUsuario = "Entrenador";
			disciplina = textDisciplina.getText();
			web = textWeb.getText();

			if (disciplina.isEmpty()) {
				JOptionPane.showMessageDialog(this, "La disciplina es obligatoria para los entrenadores", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar si es Deportista o Entrenador", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//Verifico formato mail
		if (!Pattern.compile("^[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$").matcher(email).matches()) {
			JOptionPane.showMessageDialog(this, "El formato del correo electrónico no es válido", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
    
		//Verifico formato fecha
		if (!Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$").matcher(fechaNacimiento).matches()) {
			JOptionPane.showMessageDialog(this, "El formato de la Fecha no es válido, usar 'dd/mm/aaaa'", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//Parsero de string a localDate
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha = LocalDate.parse(fechaNacimiento, formatoFecha);
		
		//Verifico si existe usuario con mismo nick/email
		if (manejarPersistencia.usuarioExiste(nickname, email)) {
			JOptionPane.showMessageDialog(this, "El nickname o el correo electrónico ya están en uso", "Error", JOptionPane.ERROR_MESSAGE);
			return;
			
		}
		
		//Ingreso los datos a la db
		iControladorUsuario.AltaUsuario(nickname, contrasena, nombre, apellido, email, fecha, tipoUsuario, esProfesional, disciplina, web);
		
		//Limmpio los campos y oculto el panel
		yo.dispose();

	}



}
