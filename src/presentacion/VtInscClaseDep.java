package presentacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import datatype.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import excepciones.ClaseNoExisteException;
import excepciones.PersistenciaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import logica.IControladorActividad;
import logica.IControladorClaseDeportiva;
import modelo.Actividad;
import modelo.ClaseDeportiva;

public class VtInscClaseDep extends JInternalFrame{
	JButton btnCancelar;
	private JTextField textFechaAlta;
	private JTextField textCupos;
	private JTextField textLugar;
	private JTextField textHora;
	private JTextField textFecha;
	private JTextField textCantidadInscrip;
	private JTextField textFechaInscrip;
	private JTextField textNombreAct;
	private JTextField textNombreCla;
	private JList<String> listActividades;
	private JList<String> listClases;
	private JList<String> listDeportistas;
	private VtPrincipal principal;
	private IControladorActividad iControladorActividad;
	private IControladorClaseDeportiva iControladorClase;
	private JInternalFrame yo = this;
	
	public VtInscClaseDep(IControladorActividad ia, IControladorClaseDeportiva ic, VtPrincipal VtPrincipal) {
		principal = VtPrincipal;
		iControladorActividad = ia;
		iControladorClase = ic;
		principal.bajarFrameActual();
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Inscripcion");
		setSize( 650, 370);
		getContentPane().setLayout(null);	
		getContentPane().setBackground(Color.decode("#cbdad5"));
		principal.setFrameActual(yo);

		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yo.setVisible(false);
			}
		});
		btnCancelar.setBounds(548, 282, 100, 21);
		this.getContentPane().add(btnCancelar);
		
		//lista actividades
		listActividades = new JList<String>();
		listActividades.setBounds(10, 36, 206, 266);
		getContentPane().add(listActividades);
		
		JLabel lblActividades = new JLabel("Actividades");
		lblActividades.setBounds(10, 11, 148, 14);
		getContentPane().add(lblActividades);
		
		//lista clases segun actividad
		JList listClases = new JList<String>();
		listClases.setBounds(226, 36, 206, 138);
		getContentPane().add(listClases);
		
		JLabel lblClases = new JLabel("Clases");
		lblClases.setBounds(226, 11, 148, 14);
		getContentPane().add(lblClases);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(226, 185, 85, 14);
		getContentPane().add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(226, 210, 85, 14);
		getContentPane().add(lblHora);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(226, 235, 85, 14);
		getContentPane().add(lblLugar);
		
		JLabel lblCupos = new JLabel("Cupos");
		lblCupos.setBounds(226, 260, 85, 14);
		getContentPane().add(lblCupos);
		
		JLabel lblFechaAlta = new JLabel("Fecha de alta");
		lblFechaAlta.setBounds(226, 285, 85, 14);
		getContentPane().add(lblFechaAlta);
		
		textFechaAlta = new JTextField();
		textFechaAlta.setEnabled(false);
		textFechaAlta.setBounds(332, 282, 100, 20);
		getContentPane().add(textFechaAlta);
		textFechaAlta.setColumns(10);
		
		textCupos = new JTextField();
		textCupos.setEnabled(false);
		textCupos.setColumns(10);
		textCupos.setBounds(332, 257, 100, 20);
		getContentPane().add(textCupos);
		
		textLugar = new JTextField();
		textLugar.setEnabled(false);
		textLugar.setColumns(10);
		textLugar.setBounds(332, 232, 100, 20);
		getContentPane().add(textLugar);
		
		textHora = new JTextField();
		textHora.setEnabled(false);
		textHora.setColumns(10);
		textHora.setBounds(332, 207, 100, 20);
		getContentPane().add(textHora);
		
		textFecha = new JTextField();
		textFecha.setEnabled(false);
		textFecha.setColumns(10);
		textFecha.setBounds(332, 182, 100, 20);
		getContentPane().add(textFecha);
		
		listDeportistas = new JList<String>();
		listDeportistas.setBounds(442, 36, 206, 138);
		getContentPane().add(listDeportistas);
		
		JLabel lblDeportista = new JLabel("Deportista");
		lblDeportista.setBounds(442, 11, 206, 14);
		getContentPane().add(lblDeportista);
		
		JLabel lblCantidadInscrip = new JLabel("Cantidad");
		lblCantidadInscrip.setBounds(441, 185, 97, 14);
		getContentPane().add(lblCantidadInscrip);
		
		JLabel lblFechaInscrip = new JLabel("Fecha");
		lblFechaInscrip.setBounds(442, 210, 96, 14);
		getContentPane().add(lblFechaInscrip);
		
		textCantidadInscrip = new JTextField();
		textCantidadInscrip.setBounds(548, 182, 100, 20);
		getContentPane().add(textCantidadInscrip);
		textCantidadInscrip.setColumns(10);
		
		textFechaInscrip = new JTextField();
		textFechaInscrip.setColumns(10);
		textFechaInscrip.setBounds(548, 207, 100, 20);
		getContentPane().add(textFechaInscrip);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(438, 282, 100, 21);
		getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yo.dispose();
			}
		});
		
	    textNombreAct = new JTextField();
	    textNombreAct.setBounds(332, 36, 100, 20);
	    getContentPane().add(textNombreAct);
	    textNombreAct.setVisible(false);
	    
	    textNombreCla = new JTextField();
	    textNombreCla.setBounds(332, 36, 100, 20);
	    getContentPane().add(textNombreCla);
	    textNombreCla.setVisible(false);
	    
		//EVENTOS ========================================================================
	   
		addComponentListener ( new ComponentAdapter () {
	        public void componentShown ( ComponentEvent e ) {
	        	//ejecuta la funcion al cambiar el estado 'visible' del frame a true
	            cargarListaActividades();
	            cargardeportistas();
	        }
	    });

		
		listActividades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Coloca el nombre de la clase seleccionada en el textBox para buscar
				textNombreAct.setText(listActividades.getSelectedValue());
				//listClases.removeAll();
				if(iControladorActividad.actividadExiste(textNombreAct.getText())) {
					listClases.setListData(iControladorActividad.obtenerVectorClasesActividad(textNombreAct.getText()));
				}
			}
		});
		
		listClases.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textNombreCla.setText((String) listClases.getSelectedValue());
				ClaseDeportiva cla = iControladorClase.obtenerClase(textNombreCla.getText());
				textFecha.setText(cla.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
				textHora.setText(cla.getHora().toString());
				textLugar.setText(cla.getLugar());
				textFechaAlta.setText(cla.getFechaAlta().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			}
		});
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AltaInscripcion();
				} catch (PersistenciaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
	}
	
	private void AltaInscripcion() throws PersistenciaException{
		
		String NomDep = listDeportistas.getSelectedValue();
		String NomCla = textNombreCla.getText();
		String CantidadIns = textCantidadInscrip.getText();
		String FechaInscripcion = textFechaInscrip.getText();
		boolean DepenClase = iControladorClase.DeportistaEstaEnClase(NomDep,NomCla);
		int cuposdis = iControladorClase.CuposDisponiblesEnClase(NomCla);
		int numcantidadIns = Integer.parseInt(textCantidadInscrip.getText());
		if (cuposdis < numcantidadIns) {
			JOptionPane.showMessageDialog(this, "No hay tantos cupos disponibles para la clase: " + NomCla, "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}		
		if (DepenClase) {
		    JOptionPane.showMessageDialog(this, "El deportista ya esta inscripto en la clase", "Error", JOptionPane.ERROR_MESSAGE);
		    return;
		}
		if (!CantidadIns.matches("\\d+")) {
		    JOptionPane.showMessageDialog(this, "La cantidad de inscriptos debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
		    return;
		}
		if (!Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$").matcher(FechaInscripcion).matches()) {
			JOptionPane.showMessageDialog(this, "El formato de la Fecha no es válido, usar 'dd/mm/aaaa'", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		LocalDate fechaAux = LocalDate.parse(FechaInscripcion, DateTimeFormatter.ofPattern("dd/MM/yyyy"));	 
		try {
			iControladorClase.AltainscripcionAClase(NomCla, NomDep,numcantidadIns, fechaAux);
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (ClaseNoExisteException e) {
			
			e.printStackTrace();
		}
		
	}
	

	
	private void cargardeportistas() {

				EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
				EntityManager em = emf.createEntityManager();
				try {
			        DefaultListModel<String> listModel = new DefaultListModel<>();
			        listDeportistas.setModel(listModel);
					Query buscarDeportistas = em.createNativeQuery("SELECT NICKNAME FROM USUARIO WHERE DTYPE LIKE 'Deportista'");
					List<String> deportistas = buscarDeportistas.getResultList();
					for (String ent : deportistas) {
						listModel.addElement(ent);
					}
				} finally {
					em.close();
					emf.close();
	}}
	
	private void cargarListaActividades() {
		//limpia la lista
		listActividades.removeAll();
		//completar la lista con datos
		listActividades.setListData(iControladorActividad.obtenerVectorActividad());
	}
	

	
	

	
}