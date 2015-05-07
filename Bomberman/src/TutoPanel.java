import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class TutoPanel extends JPanel {
	
	public void paintComponent(Graphics g){
		ImageIcon img = new ImageIcon(getClass().getResource("tutorial.png"));
		super.paintComponent(g); 
		img.paintIcon(this, g, 0, 0);
	}
}
