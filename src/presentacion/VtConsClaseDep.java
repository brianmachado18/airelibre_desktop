package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

public class VtConsClaseDep extends JInternalFrame{
	JButton btnCerrar;
	private JInternalFrame yo = this;
	private VtPrincipal principal;
	public VtConsClaseDep(VtPrincipal VtPrincipal) {
		
		setTitle("Consulta Clase");
		principal = VtPrincipal;
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
		btnCerrar.setBounds(152, 201, 85, 21);
		this.getContentPane().add(btnCerrar);
	}
}