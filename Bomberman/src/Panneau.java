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
	public Bedrock blokk = new Bedrock(5,6);
	public Board board = new Board();

  public void paintComponent(Graphics g){
	  super.paintComponent(g);
	  this.setBackground(Color.white);

	  // Joueur
	  try{
		  Image img = ImageIO.read(new File("image1.gif"));
		  g.drawImage(img, posX*64, posY*64, this);
	  }catch (IOException e){
		  e.printStackTrace();
	  }
	  
	  
	  
	  //Plateau de jeu
	  for(int i = 0; i < board.table.length; i++){
		  for(int j = 0; j < board.table.length; j++){
			  if(board.table[i][j] != null){
				  try{
					  Image img = ImageIO.read(new File(board.table[i][j].skin));
					  g.drawImage(img, board.table[i][j].getPosx()*64, board.table[i][j].getPosy()*64, this);
				  }catch (IOException e){
					  e.printStackTrace();
				  }
				  
				  
			  }
		  }
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