package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VtAltaActDep extends JInternalFrame{
	private VtPrincipal VtPrincipal;
	public VtAltaActDep(VtPrincipal principal) {
		VtPrincipal = principal;
		this.setClosable(true);
		this.setBounds(758, 76, 249, 214);
		this.setVisible(false);
	}	
}