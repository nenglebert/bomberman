import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class DataPanel extends JPanel{
	
	public void paintComponent(Graphics g){
		ImageIcon img = new ImageIcon(getClass().getResource("data.jpg"));
		super.paintComponent(g); 
		img.paintIcon(this, g, 0, 0);
	}

}
