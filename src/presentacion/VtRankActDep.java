package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

import javax.swing.JTable;

import logica.IControladorActividad;

import javax.swing.JScrollPane;

public class VtRankActDep extends JInternalFrame{
	private JTable tableRank;
	private JButton btnCerrar;
	private JInternalFrame yo = this;
	private IControladorActividad iControladorActividad;
	private VtPrincipal principal;
	
	public VtRankActDep(IControladorActividad i, VtPrincipal VtPrincipal) {
		setTitle("Ranking");
		principal = VtPrincipal;
		iControladorActividad = i;
		principal.bajarFrameActual();
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize( 650, 370);
		getContentPane().setLayout(null);	
		getContentPane().setBackground(Color.decode("#cbdad5"));
		principal.setFrameActual(yo);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yo.dispose();
			}
		});
		btnCerrar.setBounds(10, 285, 226, 21);
		this.getContentPane().add(btnCerrar);
	    
		String[][] data = iControladorActividad.obtenerArrRankingActividades();
		String [] titulo = {"Actividad", "Clases"};
		
		tableRank = new JTable(data, titulo);
		getContentPane().add(tableRank);
		
		// adding it to JScrollPane
        JScrollPane sp = new JScrollPane(tableRank);
        sp.setBounds(10, 36, 226, 238);
        getContentPane().add(sp);
		
	}	
}