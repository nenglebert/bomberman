import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Fenetre extends JFrame implements KeyListener{
	
	/**
	 * 
	 */
	public Panneau pan;


	//Constructeur de la simple fenêtre
	public Fenetre(){		
		this.addKeyListener(this);
		pan = new Panneau();
		
		//Propre � JFrame
		this.setTitle("Bomberman !");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//Conteneur utile
		pan.setPreferredSize(new Dimension(960,960));
		
		//Ajoute le contenu JPanel
		this.setContentPane(pan);
		this.pack();
		this.setVisible(true);
		
		//Recharge la page
		go();
	}
	
	/////////////////
	//Lorsqu'une touche est appuy�e
	public void keyPressed(KeyEvent e){
		int x = pan.getPosX();
		int y = pan.getPosY();
		if(e.getKeyCode()==KeyEvent.VK_RIGHT && x < 14)
			 pan.setPosX(x+1);
		 if(e.getKeyCode()==KeyEvent.VK_LEFT && x > 0)
			 pan.setPosX(x-1);
		 
		 if(e.getKeyCode()==KeyEvent.VK_UP && y > 0)
			 pan.setPosY(y-1);
		 if(e.getKeyCode()==KeyEvent.VK_DOWN && y < 14)
			 pan.setPosY(y+1);
		 
		
	}
	
	//Touche lach�e
	public void keyReleased(KeyEvent e){}
	
	//Par ex : CTRL + touch
	public void keyTyped(KeyEvent e){}
	
	
	//Actualise l'affichage
	private void go(){  
		while(true){
			//On redessine notre Panneau
		      pan.repaint();
		      try {
		        Thread.sleep(3);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		}
	}
}

  
