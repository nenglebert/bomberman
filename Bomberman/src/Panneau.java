import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	//Position initiale
	public int posX = 0;
	public int posY = 0;

  public void paintComponent(Graphics g){
	  super.paintComponent(g);
	  this.setBackground(Color.white);

	 
	
	  try{
		  Image img = ImageIO.read(new File("image1.gif"));
		  g.drawImage(img, posX*64, posY*64, this);
	  }catch (IOException e){
		  e.printStackTrace();
	  }
  }  
  
  // METHODES GET
  public int getPosX() {
    return posX;
  }
  public int getPosY() {
	    return posY;
	  }

  
  // METHODES SET
  public void setPosX(int posX) {
    this.posX = posX;
  }
  public void setPosY(int posY) {
    this.posY = posY;
  }        
}