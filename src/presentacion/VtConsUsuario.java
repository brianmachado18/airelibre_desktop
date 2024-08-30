package presentacion;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.util.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.*;

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

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import modelo.Deportista;
import modelo.Entrenador;

import javax.swing.JComboBox;

public class VtConsUsuario extends JInternalFrame{
	private JTextField textNombreConsulta;
	private JTextField textApellidoConsulta;
	private JTextField textEmailConsulta;
	private JTextField textFechaConsulta;
	private JTextField textDisciplinaConsulta;
	private JComboBox listConsultaUsuario;
	private JTextField textWebConsulta;
	private JInternalFrame yo = this;
	private VtPrincipal principal;
	private JRadioButton rdbtnEntrenadorConsulta;
	private JRadioButton rdbtnDeportistaConsulta;
	private JCheckBox chckbxEsProfesioanlConsulta;

	public VtConsUsuario(VtPrincipal VtPrincipal) {
		principal = VtPrincipal;
		principal.bajarFrameActual();
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
		btmBuscarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
				EntityManager em = emf.createEntityManager();
				
				String nick = listConsultaUsuario.getSelectedItem().toString();
				
				Query buscarUsuario = em.createNativeQuery("SELECT DTYPE FROM USUARIO WHERE NICKNAME = ?");
				buscarUsuario.setParameter(1, nick);
				Query buscarId = em.createNativeQuery("SELECT ID FROM USUARIO WHERE NICKNAME = ?");
				buscarId.setParameter(1, nick);
		        int ID = (int) buscarId.getSingleResult();

				
				if(buscarUsuario.getSingleResult() == "Entrenador") {

					Entrenador traerEntrador = em.find(Entrenador.class, ID);
					
					textNombreConsulta.setText(traerEntrador.getNombre());
					textApellidoConsulta.setText(traerEntrador.getApellido());
					textEmailConsulta.setText(traerEntrador.getMail());
					//textFechaConsulta.setText((String)traerEntrador.getFechaNacimiento());
					textDisciplinaConsulta.setText(traerEntrador.getDisciplina());
					textWebConsulta.setText(traerEntrador.getSitioWeb());
					rdbtnEntrenadorConsulta.setSelected(true);
					
				}else {
					Deportista traerDeportista = em.find(Deportista.class, ID);
					
					textNombreConsulta.setText(traerDeportista.getNombre());
					textApellidoConsulta.setText(traerDeportista.getApellido());
					textEmailConsulta.setText(traerDeportista.getMail());
					//textFechaConsulta.setText((String)traerEntrador.getFechaNacimiento());
					rdbtnDeportistaConsulta.setSelected(true);
					//chckbxEsProfesioanlConsulta.setSelected(traerDeportista.getEsProfesional());
					
					
				}

				em.close();
				emf.close();

			}
		});
		
		addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
				EntityManager em = emf.createEntityManager();
							
				
				try {
					listConsultaUsuario.removeAllItems();
					Query buscarUsuario = em.createNativeQuery("SELECT NICKNAME FROM USUARIO");
					List<String> usuarios = buscarUsuario.getResultList();

					for (String us : usuarios) {
						listConsultaUsuario.addItem(us);
					}
				}finally {
					em.close();
					emf.close();
				}
			}
		});
		
		
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
		
		rdbtnEntrenadorConsulta = new JRadioButton("Entrenador");
		rdbtnEntrenadorConsulta.setEnabled(false);
		rdbtnEntrenadorConsulta.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnEntrenadorConsulta.setBounds(403, 143, 233, 21);
		this.getContentPane().add(rdbtnEntrenadorConsulta);
		
		rdbtnDeportistaConsulta = new JRadioButton("Deportista");
		rdbtnDeportistaConsulta.setEnabled(false);
		rdbtnDeportistaConsulta.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnDeportistaConsulta.setBounds(403, 80, 233, 21);
		this.getContentPane().add(rdbtnDeportistaConsulta);
		
		JPanel panelDeposrtista_1 = new JPanel();
		panelDeposrtista_1.setBounds(403, 100, 233, 33);
		this.getContentPane().add(panelDeposrtista_1);
		
		chckbxEsProfesioanlConsulta = new JCheckBox("Profesional");
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
				yo.dispose();
			}
		});
		btnCancelarConsulta.setBounds(527, 301, 105, 21);
		this.getContentPane().add(btnCancelarConsulta);
		
		listConsultaUsuario = new JComboBox();
		listConsultaUsuario.setBounds(238, 21, 96, 22);
		getContentPane().add(listConsultaUsuario);
	}
}