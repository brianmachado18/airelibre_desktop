package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.*;

import logica.Fabrica;
import logica.IControladorActividad;
import logica.IControladorClaseDeportiva;
import logica.IControladorUsuario;

/*VENTANAS PENDIENTES
 * Modificar usuario(OPCIONAL)
 * MOD actividad deportiva(OPCIONAL)
 * */
public class VtPrincipal extends JFrame {
	private VtPrincipal yo = this;
	private JInternalFrame frameActual = null;
	private IControladorUsuario ICU;
	private IControladorActividad ICA;
	private IControladorClaseDeportiva ICC;// Objeto de tipo controlador para manipulacion de objetos

	public VtPrincipal() {
		// Inicializacion
		Fabrica fabrica = Fabrica.getInstance(); 
		ICU = fabrica.getIControladorUsuario();
		ICA = fabrica.getIControladorActividad();
		ICC = fabrica.getIControladorClaseDeportiva();// Se devuelve una instancia unica controlador de usuario
		
		setTitle("AireLibre");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setBackground(Color.decode("#89a7b1"));
		

		// Panel izquierdo para las secciones
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
        panelIzquierdo.setBackground(Color.decode("#89a7b1"));
        panelIzquierdo.setPreferredSize(new Dimension(200, 600)); // Ajustar tamaño
        
        JPanel superiorIzq = new JPanel();
        superiorIzq.setSize(100,50);
        superiorIzq.setLayout(new BoxLayout(superiorIzq, BoxLayout.X_AXIS));
		ImageIcon img = new ImageIcon("imagenes/hogar.png");
		Image imagenEscalada = img.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH); // Cambia el tamaño deseado
		JButton img2 = new JButton(new ImageIcon(imagenEscalada));
		img2.setSize(25,25);
		superiorIzq.add(img2);
		panelIzquierdo.add(superiorIzq);
		
		
        // Lista de secciones
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Usuario");
        model.addElement("Actividad");
        model.addElement("Clases e Inscripciones");

        JList<String> listaSecciones = new JList<>(model);
        listaSecciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaSecciones.setVisibleRowCount(3);
        JScrollPane scrollPaneSecciones = new JScrollPane(listaSecciones);
        panelIzquierdo.add(scrollPaneSecciones);

        // Panel para las subopciones
        DefaultListModel<String> modelSubopciones = new DefaultListModel<>();
        JList<String> listaSubopciones = new JList<>(modelSubopciones);
        listaSubopciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaSubopciones.setVisibleRowCount(4);
        JScrollPane scrollPaneSubopciones = new JScrollPane(listaSubopciones);
        panelIzquierdo.add(scrollPaneSubopciones);

     // Panel para mostrar InternalFrames
        JDesktopPane desktopPane = new JDesktopPane(); // Panel para InternalFrames
        desktopPane.setPreferredSize(new Dimension(1000, 600)); // Ajustar tamaño
        desktopPane.setBackground(Color.decode("#89a7b1"));
        desktopPane.setLayout(new BorderLayout());
        
        // Acción para la lista de secciones
        listaSecciones.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String seleccion = listaSecciones.getSelectedValue();
                modelSubopciones.clear(); // Limpiar subopciones anteriores

                switch (seleccion) {
                    case "Usuario":
                        modelSubopciones.addElement("Alta Usuario");
                        modelSubopciones.addElement("Consulta Usuario");
                        modelSubopciones.addElement("Modificar Usuario");
                        break;
                    case "Actividad":
                        modelSubopciones.addElement("Alta Actividad");
                        modelSubopciones.addElement("Consulta Actividad");
                        modelSubopciones.addElement("Modificar Actividad");
                        modelSubopciones.addElement("Ranking Actividad");
                        break;
                    case "Clases e Inscripciones":
                        modelSubopciones.addElement("Alta Clase");
                        modelSubopciones.addElement("Consulta Clase");
                        modelSubopciones.addElement("Alta Inscripción");
                        modelSubopciones.addElement("Consulta Inscripción");
                        break;
                }
            }
        });

     // Escuchador para la lista de subopciones
        listaSubopciones.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String seleccionSubopcion = listaSubopciones.getSelectedValue();
                if (seleccionSubopcion != null) {
                    switch (seleccionSubopcion) {
                        case "Alta Usuario":
                            // Lógica para alta de usuario
                        	mostrarVtAltaUsuario(desktopPane);
                            break;
                        case "Consulta Usuario":
                            // Lógica para consulta de usuario
                        	mostrarVtConsUsuario(desktopPane);
                            break;
                        case "Modificar Usuario":
                            // Lógica para modificar usuario
                        	mostrarMensaje("MODIFICAR USUARIO PENDIENTE");
                            break;
                        case "Alta Actividad":
                            // Lógica para alta de actividad
                        	mostrarVtAltaActividad(desktopPane);
                            break;
                        case "Consulta Actividad":
                            // Lógica para consulta de actividad
                        	mostrarVtConsActividad(desktopPane);
                            break;
                        case "Modificar Actividad":
                            // Lógica para modificar actividad
                        	mostrarMensaje("MODIFICAR ACTIVIDAD PENDIENTE");
                            break;
                        case "Ranking Actividad":
                            // Lógica para mostrar ranking de actividad
                        	mostrarVtRankActividad(desktopPane);
                            break;
                        case "Alta Clase":
                            // Lógica para alta de clase
                        	mostrarVtAltaClase(desktopPane);
                            break;
                        case "Consulta Clase":
                            // Lógica para consulta de clase
                        	mostrarVtConsClase(desktopPane);
                            break;
                        case "Alta Inscripción":
                            // Lógica para alta de inscripción
                        	mostrarVtInscClase(desktopPane);
                            break;
                        case "Consulta Inscripción":
                            // Lógica para consulta de inscripción
                        	mostrarVtConsInsc(desktopPane);
                            break;
                    }
                }
            }
        });
        


		img2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frameActual != null) {
					frameActual.dispose();
				}
			}
		});
		
        // Añadir los paneles al frame
        setLayout(new BorderLayout());
        add(panelIzquierdo, BorderLayout.WEST);
        add(desktopPane, BorderLayout.CENTER);

        setVisible(true);
		
	}
	public void setFrameActual(JInternalFrame actual){
    	frameActual = actual;
    }
    public void bajarFrameActual(){
    	if(frameActual != null) {
    		frameActual.dispose();
    	}	
    }
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
    private void mostrarVtAltaUsuario(JDesktopPane panel) {
        VtAltaUsuario IFAltaUsuario = new VtAltaUsuario(ICU,yo);
    	IFAltaUsuario.setVisible(true);
        panel.add(IFAltaUsuario);
    }
    private void mostrarVtConsUsuario(JDesktopPane panel) {
		VtConsUsuario IFConsUsuario = new VtConsUsuario(ICU, yo);
		IFConsUsuario.setVisible(true);
		panel.add(IFConsUsuario);
    }
    private void mostrarVtAltaActividad(JDesktopPane panel) {
		VtAltaActDep IFAltaActividad = new VtAltaActDep(ICU, ICA, yo);
		IFAltaActividad.setVisible(true);
		panel.add(IFAltaActividad);
    }
    private void mostrarVtConsActividad(JDesktopPane panel) {
    	VtConsActDep IFConsultaActividad = new VtConsActDep(ICA, yo);
    	IFConsultaActividad.setVisible(true);
    	panel.add(IFConsultaActividad);
    }
    private void mostrarVtRankActividad(JDesktopPane panel) {
    	VtRankActDep IFRankActDep = new VtRankActDep(yo);
    	IFRankActDep.setVisible(true);
    	panel.add(IFRankActDep);
    }
    private void mostrarVtAltaClase(JDesktopPane panel) {
    	VtAltaClaseDep IFAltaClaseDep = new VtAltaClaseDep(yo);
    	IFAltaClaseDep.setVisible(true);
    	panel.add(IFAltaClaseDep);
    }
    private void mostrarVtConsClase(JDesktopPane panel) {
    	VtConsClaseDep IFConsClaseDep = new VtConsClaseDep(yo);
    	IFConsClaseDep.setVisible(true);
    	panel.add(IFConsClaseDep);
    }
    private void mostrarVtInscClase(JDesktopPane panel) {
		VtInscClaseDep IFInscClaseDep = new VtInscClaseDep(yo);
    	IFInscClaseDep.setVisible(true);
    	panel.add(IFInscClaseDep);
    }
    private void mostrarVtConsInsc(JDesktopPane panel) {
    	VtConsInsc IFConsInsc = new VtConsInsc(yo);
    	IFConsInsc.setVisible(true);
    	panel.add(IFConsInsc);
    }
}