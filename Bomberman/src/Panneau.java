import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	//Position initiale
	private int posX = 50;
	private int posY = 50;

  public void paintComponent(Graphics g){
	  super.paintComponent(g);
	  this.setBackground(Color.white);
	
	  try{
		  Image img = ImageIO.read(new File("bomberman.png"));
		  g.drawImage(img, posX, posY, this);
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