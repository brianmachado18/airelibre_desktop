package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

public class VtAltaClaseDep extends JInternalFrame{
	JButton btnCerrar;
	JInternalFrame yo = this;
	public VtAltaClaseDep() {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(47, 40, 263, 263);
		this.getContentPane().setLayout(null);
		this.setTitle("Alta Clase");
		this.setVisible(false);
		this.setClosable(false);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yo.setVisible(false);
			}
		});
		btnCerrar.setBounds(152, 201, 85, 21);
		this.getContentPane().add(btnCerrar);
	}	
}