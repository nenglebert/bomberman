import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Gestion de la fenêtre "containeur" du jeu
@SuppressWarnings("serial")
public class GameWindow extends JFrame{
	private GamePanel gamePanel;		//Le panel global avec image	
	private JPanel dataPanel;
	private Player[] playerList;
	
	public GameWindow(){
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setResizable(false);
		
		//Création de nos objets
		try {
			gamePanel = new GamePanel(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dataPanel = new JPanel();
		
		dataPanel.setPreferredSize(new Dimension(100,600));
		
		
		this.setLayout(new BorderLayout());
		this.getContentPane().add(gamePanel, BorderLayout.EAST);	//Pour l'ajouter sur la fenêtre
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);		//Apparaît au milieu de l'écran
	}
	
	public void updateLabel(){
		System.out.println("coucou");
		playerList = gamePanel.getPlayerList();
		dataPanel.removeAll();
		dataPanel.setLayout(new GridLayout(playerList.length,1));
		for (int i=0; i<playerList.length; i++){
			JLabel label = new JLabel("<html>" + playerList[i].getName() + " :"
					+ "<br> life : " + playerList[i].getLife() 
					+ "<br> bomb : " + playerList[i].getBombBag() + "</html>");
			dataPanel.add(label);
		}
		this.getContentPane().add(dataPanel, BorderLayout.WEST);
		this.pack();
	}
	
	public static void main(String args[]) {
		new GameWindow();
		
	}
}
	
	
