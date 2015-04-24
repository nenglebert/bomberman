import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;


public class GameWindow extends JFrame{
	private GamePanel gamePanel;		//Le panel global avec image	 
	
	public GameWindow(){
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setResizable(false);
		
		//Création de nos objets
		gamePanel = new GamePanel();
		this.getContentPane().add(gamePanel);	//Pour l'ajouter sur la fenêtre
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);		//Apparaît au milieu de l'écran
	}
	
	public static void main(String args[]){
		GameWindow window = new GameWindow();
	}
}
	
	
