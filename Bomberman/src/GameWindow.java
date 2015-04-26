import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class GameWindow extends JFrame{
	private GamePanel gamePanel;		//Le panel global avec image	
	private JPanel dataPanel;
	private Player[] playerList;
	
	public GameWindow(){
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setResizable(false);
		
		//Création de nos objets
		gamePanel = new GamePanel(this);
		dataPanel = new JPanel();
		
		dataPanel.setPreferredSize(new Dimension(100,600));
		
		
		this.setLayout(new BorderLayout());
		this.getContentPane().add(gamePanel, BorderLayout.WEST);	//Pour l'ajouter sur la fenêtre
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);		//Apparaît au milieu de l'écran
	}
	
	public void updateLabel(){
		playerList = GamePanel.getPlayerList();
		dataPanel.removeAll();
		dataPanel.setLayout(new GridLayout(playerList.length,1));
		for (int i=0; i<playerList.length; i++){
			JLabel label = new JLabel("<html>" + playerList[i].getName() + " :"
					+ "<br> life : " + playerList[i].getLife() 
					+ "<br> bomb : " + playerList[i].getBombBag() + "</html>");
			dataPanel.add(label);
		}
		this.getContentPane().add(dataPanel);
		this.pack();
	}
	
	public static void main(String args[]) {
		GameWindow window = new GameWindow();
		
	}
}
	
	
