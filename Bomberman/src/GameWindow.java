import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kuusisto.tinysound.TinySound;

// Gestion de la fenêtre "containeur" du jeu
@SuppressWarnings("serial")
public class GameWindow extends JFrame{
	private GamePanel gamePanel;		//Le panel global avec image	
	private DataPanel dataPanel;
	private Player[] playerList;
	private ArrayList<JPanel> subPanel = new ArrayList<JPanel>();
	
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
		
		this.setLayout(new BorderLayout());
		this.getContentPane().add(gamePanel, BorderLayout.EAST);	//Pour l'ajouter sur la fenêtre
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);		//Apparaît au milieu de l'écran
	}
	
	public void createLabel(){
		dataPanel = new DataPanel();
		dataPanel.setPreferredSize(new Dimension(150,(gamePanel.getBoardSize()+1)*40));
		this.playerList = gamePanel.getPlayerList();
		dataPanel.setLayout(new GridLayout(playerList.length,1));
		for (int i=0; i<playerList.length; i++){
			JLabel label = new JLabel("<html>" + "<b>" + playerList[i].getName() + " : </b>" 
					+ "<br>"
					+ "<br> life : " + playerList[i].getLife() 
					+ "<br> bomb in bag : " + playerList[i].getBombBag() 
					+ "<br> bomb size : " + playerList[i].getBombSize() + "</html>");
			subPanel.add(new JPanel());
			subPanel.get(i).setOpaque(false);
			subPanel.get(i).add(label);
			dataPanel.add(subPanel.get(i));
		}
		this.getContentPane().add(dataPanel, BorderLayout.WEST);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public void updateLabel(int i){
		JLabel label = new JLabel("<html>" + "<b>" + playerList[i].getName() + " : </b>" 
				+ "<br>"
				+ "<br> life : " + playerList[i].getLife() 
				+ "<br> bomb in bag : " + playerList[i].getBombBag() 
				+ "<br> bomb size : " + playerList[i].getBombSize() + "</html>");
		subPanel.get(i).removeAll();
		subPanel.get(i).add(label);
		dataPanel.revalidate();
	}
	
	public static void main(String args[]) {
		TinySound.init();
		new GameWindow();
		
	}
}
	
	
