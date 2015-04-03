import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class ImagePanel extends JPanel {

	public void paintComponent(Graphics g) {
	ImageIcon img = new ImageIcon("Background2.jpg");
	super.paintComponent(g); 
	img.paintIcon(this, g, 0, 0);
	} 
}