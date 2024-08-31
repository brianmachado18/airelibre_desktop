package presentacion;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import excepciones.PersistenciaException;
import logica.IControladorUsuario;
import modelo.Deportista;
import modelo.Entrenador;

import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VtConsUsuario extends JInternalFrame{
	private JTextField textNombreConsulta;
	private JTextField textApellidoConsulta;
	private JTextField textEmailConsulta;
	private JTextField textFechaConsulta;
	private JTextField textDisciplinaConsulta;
	private JTextField textWebConsulta;
	private JInternalFrame yo = this;
	private VtPrincipal principal;
	private JRadioButton rdbtnEntrenadorConsulta;
	private JRadioButton rdbtnDeportistaConsulta;
	private JCheckBox chckbxEsProfesioanlConsulta;
	private JList<String> listUsuarios;
	private IControladorUsuario iControladorUsuario;
	private JTextField textNicknameConsulta;

	public VtConsUsuario(IControladorUsuario i, VtPrincipal VtPrincipal) {
		principal = VtPrincipal;
		principal.bajarFrameActual();
		//Inicio el controlador usuario
		iControladorUsuario = i;
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(650, 370);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.decode("#cbdad5"));
		setTitle("Consulta Usuario");
		setVisible(false);
		principal.setFrameActual(yo);
		
		Label lblNicknameConsulta = new Label("Nickname");
		lblNicknameConsulta.setBounds(158, 21, 62, 22);
		this.getContentPane().add(lblNicknameConsulta);
		
		Button btmBuscarConsulta = new Button("Buscar");
		btmBuscarConsulta.setBounds(352, 21, 70, 22);
		this.getContentPane().add(btmBuscarConsulta);
		
		textNombreConsulta = new JTextField();
		textNombreConsulta.setEnabled(false);
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
		textApellidoConsulta.setEnabled(false);
		textApellidoConsulta.setEditable(false);
		textApellidoConsulta.setColumns(10);
		textApellidoConsulta.setBounds(275, 144, 96, 19);
		this.getContentPane().add(textApellidoConsulta);
		
		textEmailConsulta = new JTextField();
		textEmailConsulta.setEnabled(false);
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
		textFechaConsulta.setEnabled(false);
		textFechaConsulta.setEditable(false);
		textFechaConsulta.setColumns(10);
		textFechaConsulta.setBounds(275, 204, 96, 19);
		this.getContentPane().add(textFechaConsulta);
		
		rdbtnEntrenadorConsulta = new JRadioButton("Entrenador");
		rdbtnEntrenadorConsulta.setBackground(new Color(203, 218, 213));
		rdbtnEntrenadorConsulta.setEnabled(false);
		rdbtnEntrenadorConsulta.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnEntrenadorConsulta.setBounds(403, 143, 233, 21);
		this.getContentPane().add(rdbtnEntrenadorConsulta);
		
		rdbtnDeportistaConsulta = new JRadioButton("Deportista");
		rdbtnDeportistaConsulta.setBackground(new Color(203, 218, 213));
		rdbtnDeportistaConsulta.setEnabled(false);
		rdbtnDeportistaConsulta.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnDeportistaConsulta.setBounds(403, 80, 233, 21);
		this.getContentPane().add(rdbtnDeportistaConsulta);
		
		JPanel panelDeposrtista_1 = new JPanel();
		panelDeposrtista_1.setBackground(new Color(203, 218, 213));
		panelDeposrtista_1.setBounds(403, 100, 233, 33);
		this.getContentPane().add(panelDeposrtista_1);
		
		chckbxEsProfesioanlConsulta = new JCheckBox("Profesional");
		chckbxEsProfesioanlConsulta.setBackground(new Color(203, 218, 213));
		chckbxEsProfesioanlConsulta.setEnabled(false);
		panelDeposrtista_1.add(chckbxEsProfesioanlConsulta);
		
		JPanel panelEntrenador_1 = new JPanel();
		panelEntrenador_1.setBackground(new Color(203, 218, 213));
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
		btnCancelarConsulta.setBounds(527, 301, 105, 21);
		this.getContentPane().add(btnCancelarConsulta);
		
		listUsuarios = new JList<String>();
		listUsuarios.setBounds(10, 11, 137, 318);
		getContentPane().add(listUsuarios);
		
		textNicknameConsulta = new JTextField();
		textNicknameConsulta.setColumns(10);
		textNicknameConsulta.setBounds(238, 21, 96, 19);
		getContentPane().add(textNicknameConsulta);
		
		//EVENTOS
		addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				Vector<String> vUsuarios = null;
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
				textNicknameConsulta.setText(listUsuarios.getSelectedValue());
			}
		});

		btmBuscarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
				String nick = textNicknameConsulta.getText();
				try {
					if(iControladorUsuario.usuarioExiste(nick)) {
						if (iControladorUsuario.esEntrenador(nick)) {
							Entrenador traerEntrenador = iControladorUsuario.obtenerEntrenador(nick);
							textNombreConsulta.setText(traerEntrenador.getNombre());
							textApellidoConsulta.setText(traerEntrenador.getApellido());
							textEmailConsulta.setText(traerEntrenador.getMail());
							textFechaConsulta.setText(traerEntrenador.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
							rdbtnEntrenadorConsulta.setSelected(true);
							textDisciplinaConsulta.setText(traerEntrenador.getDisciplina());
							textWebConsulta.setText(traerEntrenador.getSitioWeb());
						} else {
							Deportista traerDeportista = iControladorUsuario.obtenerDeportista(nick);
							textNombreConsulta.setText(traerDeportista.getNombre());
							textApellidoConsulta.setText(traerDeportista.getApellido());
							textEmailConsulta.setText(traerDeportista.getMail());
							textFechaConsulta.setText(traerDeportista.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
							rdbtnDeportistaConsulta.setSelected(true);
							chckbxEsProfesioanlConsulta.setSelected(traerDeportista.isEsProfesional());
						}
					} else {
						JOptionPane.showMessageDialog( textNicknameConsulta, "El usuario no existe","Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} catch (PersistenciaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnCancelarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yo.dispose();
			}
		});
	}
	
	public void limpiarCampos() {
		textNombreConsulta.setText("");
		textApellidoConsulta.setText("");
		textEmailConsulta.setText("");
		textFechaConsulta.setText("");
		rdbtnDeportistaConsulta.setSelected(false);
		chckbxEsProfesioanlConsulta.setSelected(false);
		rdbtnEntrenadorConsulta.setSelected(false);
		textDisciplinaConsulta.setText("");
		textWebConsulta.setText("");
	}
	
}