package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VtRankActDep extends JInternalFrame{
	private JLabel lblClases;
	private JLabel lblActividad;
	private JTable tableRank;
	private JButton btnCerrar;
	JInternalFrame yo = this;
	
	public VtRankActDep() {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(47, 40, 263, 343);
		this.getContentPane().setLayout(null);
		this.setTitle("Ranking");
		this.setVisible(false);
		this.setClosable(false);
		
		lblClases = new JLabel("Cantidad de clases");
		lblClases.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClases.setBounds(127, 11, 109, 14);
		getContentPane().add(lblClases);
		
		lblActividad = new JLabel("Actividad");
		lblActividad.setHorizontalAlignment(SwingConstants.LEFT);
		lblActividad.setBounds(10, 11, 107, 14);
		getContentPane().add(lblActividad);
		
		tableRank = new JTable();
		tableRank.setBounds(10, 36, 226, 238);
		getContentPane().add(tableRank);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yo.setVisible(false);
			}
		});
		btnCerrar.setBounds(10, 285, 226, 21);
		this.getContentPane().add(btnCerrar);
		
	}	
}