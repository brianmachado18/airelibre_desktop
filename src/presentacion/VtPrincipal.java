package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;


/*VENTANAS PENDIENTES
 * Modificar usuario(OPCIONAL)
 * MOD actividad deportiva(OPCIONAL)
 * */
public class VtPrincipal extends JFrame{
	JFrame yo = this;
	public VtPrincipal() {
		setTitle("AireLibre");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 600);
		setLocationRelativeTo(null);
		


		/*=======================COMO INGRESAR IMAGENES=====================================0
		 * ImageIcon img = new ImageIcon("C:\\Users\\PC\\Desktop\\PAP\\airelibre_desktop\\imagenes\\hogar.png");
		 * Image imagenEscalada = img.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH); // Cambia el tamaño deseado
		 * JLabel img2 = new JLabel(new ImageIcon(imagenEscalada));
		 * img2.setBounds(10,10,200,100);
		 * this.add(img2);
		*/
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.decode("#89a7b1"));
		panelPrincipal.setLayout(new GridLayout(1, 3, 30, 30)); // 3 divisiones con espacio entre ellas
		
		JPanel fondo = new JPanel();
        fondo.setPreferredSize(new Dimension(1200, 600)); // Tamaño del fondo
        fondo.setBackground(Color.LIGHT_GRAY); // Color de fondo del fondo

		
		// Crear panel para Usuarios
        JPanel panelUsuarios = crearPanel("Usuarios", Color.decode("#cbdad5"));
        JButton altaUsuarioButton = new JButton("Alta Usuario");
        JButton consultaUsuarioButton = new JButton("Consulta Usuario");
        JButton modificarUsuarioButton = new JButton("Modificar Usuario");
        panelUsuarios.add(altaUsuarioButton);
        panelUsuarios.add(consultaUsuarioButton);
        panelUsuarios.add(modificarUsuarioButton);
        
     // Crear panel para Actividad
        JPanel panelActividad = crearPanel("Actividad", Color.decode("#cbdad5"));
        JButton altaActividadButton = new JButton("Alta Actividad");
        JButton consultaActividadButton = new JButton("Consulta Actividad");
        JButton modificarActividadButton = new JButton("Modificar Actividad");
        JButton rankingActividadButton = new JButton("Ranking Actividad");
        panelActividad.add(altaActividadButton);
        panelActividad.add(consultaActividadButton);
        panelActividad.add(modificarActividadButton);
        panelActividad.add(rankingActividadButton);
        
     // Crear panel para Clase e Inscripciones
        JPanel panelClaseInscripciones = crearPanel("Clase e Inscripciones", Color.decode("#cbdad5"));
        JButton altaClaseButton = new JButton("Alta Clase");
        JButton consultaClaseButton = new JButton("Consulta Clase");
        JButton altaInscripcionButton = new JButton("Alta Inscripción");
        JButton consultaInscripcionButton = new JButton("Consulta Inscripción");  
        panelClaseInscripciones.add(altaClaseButton);
        panelClaseInscripciones.add(consultaClaseButton);
        panelClaseInscripciones.add(altaInscripcionButton);
        panelClaseInscripciones.add(consultaInscripcionButton);
        
        //COSO
        cambiarTam(panelUsuarios);
        cambiarTam(panelActividad);
        cambiarTam(panelClaseInscripciones);
        
        // Agregar los paneles al panel principal
        panelPrincipal.add(panelUsuarios);
        panelPrincipal.add(panelActividad);
        panelPrincipal.add(panelClaseInscripciones);
        
        // Agregar el panel principal a la ventana
        fondo.add(panelPrincipal);
        add(fondo);
        
        // Hacer visible la ventana
        setVisible(true);
		
        // Acciones de los botones 
        altaUsuarioButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	mostrarVtAltaUsuario();
		    }
		});
        
        consultaUsuarioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVtConsUsuario();
			}
		});
        
        modificarUsuarioButton.addActionListener(e -> mostrarMensaje("Modificar Usuario"));
        altaActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVtAltaActividad();
			}
		});
        
        consultaActividadButton.addActionListener(e -> mostrarMensaje("Consulta Actividad"));
        modificarActividadButton.addActionListener(e -> mostrarMensaje("Modificar Actividad"));
        rankingActividadButton.addActionListener(e -> mostrarMensaje("Ranking Actividad"));
        altaClaseButton.addActionListener(e -> mostrarMensaje("Alta Clase"));
        consultaClaseButton.addActionListener(e -> mostrarMensaje("Consulta Clase"));
        altaInscripcionButton.addActionListener(e -> mostrarMensaje("Alta Inscripción"));
        consultaInscripcionButton.addActionListener(e -> mostrarMensaje("Consulta Inscripción"));
	}
	private JPanel crearPanel(String titulo, Color color) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Disposición vertical
        panel.setBorder(BorderFactory.createTitledBorder(titulo));
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(300, 400)); // Ajustar el tamaño del panel

        
        
        return panel;
        
    }
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
    private void mostrarVtAltaUsuario() {
        VtAltaUsuario FAltaUsuario = new VtAltaUsuario(this);
    	FAltaUsuario.setVisible(true);
		yo.setVisible(false);
    }
    private void mostrarVtConsUsuario() {
		VtConsUsuario FConsUsuario = new VtConsUsuario(this);
		FConsUsuario.setVisible(true);
		yo.setVisible(false);
    }
    private void mostrarVtAltaActividad() {
		VtAltaActDep FAltaActividad = new VtAltaActDep(this);
		FAltaActividad.setVisible(true);
		yo.setVisible(false);
    }
    private void cambiarTam(JPanel panel){
    	// Establecer un tamaño uniforme para los botones
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JButton) {
                ((JButton) comp).setPreferredSize(new Dimension(400, 300)); // Tamaño de botones
            }
        }  
    }
}