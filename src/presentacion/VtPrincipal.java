package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*VENTANAS PENDIENTES
 * Modificar usuario(OPCIONAL)
 * MOD actividad deportiva(OPCIONAL)
 * */
public class VtPrincipal extends JFrame{
	public VtPrincipal() {
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
		
		VtAltaUsuario IFAltaUsuario = new VtAltaUsuario();
		this.getContentPane().add(IFAltaUsuario);
		
		VtConsUsuario IFConsUsuario = new VtConsUsuario();
		this.getContentPane().add(IFConsUsuario);
		
		VtAltaActDep IFAltaActividad = new VtAltaActDep();
		this.getContentPane().add(IFAltaActividad);
		
		//=== EVENTOS MENU =========================================================================
		mntmAltaUsuario.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
				IFAltaUsuario.setVisible(false);
		    }
		});
				
		/*mntmModificarUsuario.addActionListener(new ActionListener() {
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
		OPCIONAL*/

		mntmConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Muestro el InternalFrame para consultar un usuario
				IFConsUsuario.setVisible(true);
			}
		});

		mntmAltaActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestro el InternalFrame para dar de alta una actividad
				IFAltaActividad.setVisible(true);
			}
		});
		
		//==========================================================================================
			
	}
	
}