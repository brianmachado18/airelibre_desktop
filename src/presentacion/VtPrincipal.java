package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import logica.Fabrica;
import logica.IControladorActividad;
import logica.IControladorClaseDeportiva;
import logica.IControladorUsuario;

/*VENTANAS PENDIENTES
 * Modificar usuario(OPCIONAL)
 * MOD actividad deportiva(OPCIONAL)
 * */
public class VtPrincipal extends JFrame {
	private IControladorUsuario ICU;
	private IControladorActividad ICA;
	private IControladorClaseDeportiva ICC;// Objeto de tipo controlador para manipulacion de objetos

	public VtPrincipal() {
		// Inicializacion
		Fabrica fabrica = Fabrica.getInstance(); 
		ICU = fabrica.getIControladorUsuario();
		ICA = fabrica.getIControladorActividad();
		ICC = fabrica.getIControladorClaseDeportiva();// Se devuelve una instancia unica controlador de usuario

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("AireLibre");
		this.getContentPane().setLayout(null);
		this.setVisible(true);
		this.setBounds(200, 100, 1200, 600);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu mnUsuario = new JMenu("Usuarios");
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

		VtAltaUsuario IFAltaUsuario = new VtAltaUsuario(ICU);
		this.getContentPane().add(IFAltaUsuario);

		VtConsUsuario IFConsUsuario = new VtConsUsuario();
		this.getContentPane().add(IFConsUsuario);

		VtAltaActDep IFAltaActividad = new VtAltaActDep();
		this.getContentPane().add(IFAltaActividad);

		VtConsActDep IFConsultaActividad = new VtConsActDep();
		this.getContentPane().add(IFConsultaActividad);

		VtRankActDep IFRankActDep = new VtRankActDep();
		this.getContentPane().add(IFRankActDep);

		VtAltaClaseDep IFAltaClaseDep = new VtAltaClaseDep();
		this.getContentPane().add(IFAltaClaseDep);

		VtConsClaseDep IFConsClaseDep = new VtConsClaseDep();
		this.getContentPane().add(IFConsClaseDep);

		VtInscClaseDep IFInscClaseDep = new VtInscClaseDep();
		this.getContentPane().add(IFInscClaseDep);

		VtConsInsc IFConsInsc = new VtConsInsc();
		this.getContentPane().add(IFConsInsc);

		// === EVENTOS MENU
		// =========================================================================
		mntmAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestra el InternalFrame para el alta usuario
				IFAltaUsuario.setVisible(true);
			}
		});

		mntmConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestro el InternalFrame para consultar un usuario
				IFConsUsuario.setVisible(true);
			}
		});

		mntmModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame(), "Sin Implementar (OPCIONAL)");
			}
		});

		mntmAltaActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestro el InternalFrame para dar de alta una actividad
				IFAltaActividad.setVisible(true);
			}
		});

		mntmConsultaActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestro el InternalFrame para consultfar una actividad
				IFConsultaActividad.setVisible(true);
			}
		});

		mntmModificarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame(), "Sin Implementar (OPCIONAL)");
			}
		});

		mntmRankingActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestro el InternalFrame para consultfar el ranking de actividades
				IFRankActDep.setVisible(true);
			}
		});

		mntmAltaClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestro el InternalFrame de alta clase
				IFAltaClaseDep.setVisible(true);
			}
		});

		mntmConsultaClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestro el InternalFrame de consulta clase
				IFConsClaseDep.setVisible(true);
			}
		});

		mntmAltaInscripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestro el InternalFrame de alta inscripcion
				IFInscClaseDep.setVisible(true);
			}
		});

		mntmConsultaInscripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestro el InternalFrame de consulta inscripcion
				IFConsInsc.setVisible(true);
			}
		});

		// ==========================================================================================

	}

}