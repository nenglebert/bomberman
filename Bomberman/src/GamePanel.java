import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class GamePanel extends JPanel implements KeyListener{
	
		// CrÃ©ation des diffÃ©rents objets
	private Board board;
	private Element[][] elementTable;
	protected static Player[] playerList;
	private int playerNumber;
	private GameWindow gameWindow;
	
	private JPanel subPanel = new JPanel();	//Le panel qui va contenir les boutons
	
	private JButton startButton = new JButton("Start game");	//Bouton "Start"
	private JButton tutoButton = new JButton("Tutorial");		//Bouton "Tutorial"
	private JButton player2Button = new JButton("2 Players");	//Bouton "2 players"
	private JButton player3Button = new JButton("3 Players");	//Bouton "3 players"
	private JButton player4Button = new JButton("4 Players");	//Bouton "4 players"
	private JButton validateButton = new JButton("Validate");	//Bouton "Validate"
	
	private JLabel introLabel = new JLabel("Take up the challenge and play !");
	private JLabel playerLabel = new JLabel("Choose the number of player");
	private JLabel nameLabel = new JLabel("Enter the players name");
	
	private ArrayList<JTextField> nameFields = new ArrayList<JTextField>();	//Zone pour les noms
	private ArrayList<String> nameList = new ArrayList<String>();
	
	private int begin = 0;	// ces deux suivants servent Ã  paint
	
	public GamePanel(GameWindow gameWindow){
		this.gameWindow = gameWindow;
		this.initialize();
		this.addKeyListener(this);
		this.setFocusable(true);
	}

	public void initialize() {
		
		//On sectionne le panel pour avoir 3 lignes et 1 colonne
		subPanel.setLayout(new GridLayout(3,1));
		
		//Pour que la souris devient une main (c'est joliii !)
		startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tutoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		player2Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		player3Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		player4Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		validateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//On prÃ©pare le premier affichage
		subPanel.add(introLabel);
		subPanel.add(startButton);
		subPanel.add(tutoButton);
		subPanel.setOpaque(false);		//C'est pour ne pas avoir de bouton dÃ©gueu
		this.add(subPanel);				//On met tout sur notre panel gÃ©nÃ©rale
		
		this.setPreferredSize(new Dimension(600, 600));
		
		//DÃ©finissions des boutons
		startButton.addActionListener(new StartActionListener(this,subPanel));
		player2Button.addActionListener(new PlayerActionListener(this,subPanel,2));
		player3Button.addActionListener(new PlayerActionListener(this,subPanel,3));
		player4Button.addActionListener(new PlayerActionListener(this,subPanel,4));
	}
	
/////////////////
//Lorsqu'une touche est appuyÃ©e
//Le check permet de ne rien faire si un block est la ou on
//veut aller
	public void keyPressed(KeyEvent e){
	if (begin == 1){
// Joueur 1
	int x1 = playerList[0].getPosx();
	int y1 = playerList[0].getPosy();
	
	System.out.println(x1 + " " + y1);
	if(e.getKeyCode()==KeyEvent.VK_RIGHT && x1 < 14)
		if(check(x1+1,y1,0)){
			playerList[0].setPosx(x1+1);
			if (!(board.getElemInBoard(x1, y1) instanceof Bomb))
			board.setElemInBoard(x1, y1, null);
			board.setElemInBoard(x1+1, y1, playerList[0]);
		}

	if(e.getKeyCode()==KeyEvent.VK_LEFT && x1 > 0)
		if(check(x1-1,y1,0)){
			playerList[0].setPosx(x1-1);
			if (!(board.getElemInBoard(x1, y1) instanceof Bomb))
			board.setElemInBoard(x1, y1, null);
			board.setElemInBoard(x1-1, y1, playerList[0]);
		}
	if(e.getKeyCode()==KeyEvent.VK_UP && y1 > 0)
		if(check(x1,y1-1,0)){
			playerList[0].setPosy(y1-1);
			if (!(board.getElemInBoard(x1, y1) instanceof Bomb))
			board.setElemInBoard(x1, y1, null);
			board.setElemInBoard(x1, y1-1, playerList[0]);
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN && y1 < 14)
		if(check(x1,y1+1,0)){
			playerList[0].setPosy(y1+1);	
			if (!(board.getElemInBoard(x1, y1) instanceof Bomb))
			board.setElemInBoard(x1, y1, null);
			board.setElemInBoard(x1, y1+1, playerList[0]);
		}
//BOMBAAA
	if(e.getKeyCode()==KeyEvent.VK_SPACE)
		if (playerList[0].getBombBag() > 0){
			playerList[0].setBombBag(playerList[0].getBombBag()-1);
		board.setElemInBoard(x1,y1,new Bomb(x1,y1,board,playerList[0]));
		}
		// Rajout de pan en argument
	
		// Joueur 1
		int x2 = playerList[1].getPosx();
		int y2 = playerList[1].getPosy();
		
		if(e.getKeyCode()==KeyEvent.VK_D && x2 < 14)
			if(check(x2+1,y2,1)){
				playerList[1].setPosx(x2+1);
				if (!(board.getElemInBoard(x2, y2) instanceof Bomb))
				board.setElemInBoard(x2, y2, null);
				board.setElemInBoard(x2+1, y2, playerList[1]);
			}

		if(e.getKeyCode()==KeyEvent.VK_Q && x2 > 0)
			if(check(x2-1,y2,1)){
				playerList[1].setPosx(x2-1);
				if (!(board.getElemInBoard(x2, y2) instanceof Bomb))
				board.setElemInBoard(x2, y2, null);
				board.setElemInBoard(x2-1, y2, playerList[1]);
			}
		if(e.getKeyCode()==KeyEvent.VK_Z && y2 > 0)
			if(check(x2,y2-1,1)){
				playerList[1].setPosy(y2-1);
				if (!(board.getElemInBoard(x2, y2) instanceof Bomb))
				board.setElemInBoard(x2, y2, null);
				board.setElemInBoard(x2, y2-1, playerList[1]);
			}
			if(e.getKeyCode()==KeyEvent.VK_S && y2 < 14)
			if(check(x2,y2+1,1)){
				playerList[1].setPosy(y2+1);	
				if (!(board.getElemInBoard(x2, y2) instanceof Bomb))
				board.setElemInBoard(x2, y2, null);
				board.setElemInBoard(x2, y2+1, playerList[1]);
			}
	//BOMBAAA
		if(e.getKeyCode()==KeyEvent.VK_A)
			if (playerList[1].getBombBag() > 0){
				playerList[1].setBombBag(playerList[1].getBombBag()-1);
			board.setElemInBoard(x2,y2,new Bomb(x2,y2, board, playerList[1]));	}
		// Rajout de pan en argument
		}
	}

//Check si pas de collision et donne le bonus
	public boolean check(int pX, int pY, int pPlayer){
		if (board.getElemInBoard(pX,pY) == null || board.getElemInBoard(pX, pY) instanceof Bonus){
			//Si c'est un bonus, on lui donne
			if(board.getElemInBoard(pX, pY) instanceof Bonus)
				bonus(pX,pY,pPlayer);
			return true;
		}
		else
			return false;
}
	
// Fonction bonus
public void bonus(int pX, int pY, int pPlayer){
	//Je passe par ceci car getType() est propre à la classe bonus, pas de
	//polymorphisme avec la classe Element (un peu dégueu j'avoue)
	Bonus boni = (Bonus)board.getElemInBoard(pX, pY);
	
	//Bonus bombe
	if(boni.getType() == 1)
		playerList[pPlayer].setBombBag(playerList[pPlayer].getBombBag()+1);	
	
	//Bonus vie
	if(boni.getType() == 2)
		playerList[pPlayer].setLife(playerList[pPlayer].getLife()+1);	

	//Bonus speed
	if(boni.getType() == 3)
		playerList[pPlayer].setSpeed(playerList[pPlayer].getSpeed()+1);	
}


//Touche lachï¿½e
public void keyReleased(KeyEvent e){}

//Par ex : CTRL + touch
public void keyTyped(KeyEvent e){}
	
	public void playerChooseWindow(JPanel subPanel){
		//Fait apparaÃ®tre la page 2 (choix du nombre de joueur)
		subPanel.removeAll();
		subPanel.setLayout(new GridLayout(4,1));
		
		subPanel.add(playerLabel);
		subPanel.add(player2Button);
		subPanel.add(player3Button);
		subPanel.add(player4Button);

		subPanel.revalidate();
	}
	
	public void takePlayersName(JPanel subPanel, int playerNumber){
		//RÃ©cupÃ¨re le nom des joueurs
		subPanel.removeAll();
		subPanel.setLayout(new GridLayout(2*playerNumber + 2,1));
		
		subPanel.add(nameLabel);
		// CrÃ©ation des espaces d'Ã©criture du nom
			for (int i=1; i<=playerNumber; i++){
				nameFields.add(new JTextField("Name player " + i));
				final JTextField nameField = nameFields.get(i-1);	//Pour vider le champ
				nameField.addFocusListener(new FocusAdapter() {
					public void focusGained(FocusEvent e){
						nameField.setText("");
					}
				});
				subPanel.add(nameFields.get(i-1));
			}
		
		subPanel.add(validateButton);
		validateButton.addActionListener(new ValidateActionListener(this,nameFields,playerNumber));
		
		subPanel.revalidate();
	}
	
	public void createPlayers(int playerNumber){
		this.playerNumber = playerNumber;
		System.out.println(playerNumber);
		int[] posxList = {0,14,14,0};
		int[] posyList = {0,14,0,14};
		playerList = new Player[playerNumber];
		for (int i=0;i < playerNumber;i++){
			playerList[i] = new Player("skin"+String.valueOf(i+1)+".jpeg", nameList.get(i), posxList[i], posyList[i]);
			System.out.println(i+1 + ") " + playerList[i].getName());
		}
		
		subPanel.removeAll();
		this.revalidate();
		board = new Board(playerList,this);
		elementTable = board.getTable();
		begin = 1;
		File audioFile = new File("test.wav");
		AudioInputStream audioStream;
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format); 
			Clip audioClip = (Clip) AudioSystem.getLine(info); 
			audioClip.open(audioStream);
			audioClip.loop((int) audioClip.getMicrosecondLength());
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//Les getteurs
	public String getName(int number){
		return nameList.get(number);
	}
	
	public static Player[] getPlayerList(){
		return playerList;
	}
	
	
	//Les setteurs
	public void setName(String name){
		this.nameList.add(name);
	}
	
	public void resetName(){
		this.nameList.clear();
	}
	
	public void update(){  
	    this.repaint();
	}
	
	public Board getBoard(){
		return board;
	}
	
	
	// Fonction qui va se charger de dessiner notre matrice
public void paintComponent(Graphics g){
		
		if (begin==0){
		ImageIcon img = new ImageIcon("Background.jpg");
		super.paintComponent(g); 
		img.paintIcon(this, g, 0, 0);
		}
		if (begin==1){
			this.setLayout(new GridLayout(1,2));
			//Plateau de jeu
			ImageIcon img = new ImageIcon("");
			super.paintComponent(g); 
			img.paintIcon(this, g, 0, 0);
			 this.setBackground(Color.white);
			 for(int x = 0; x < elementTable.length; x++){
				 for(int y = 0; y < elementTable.length; y++){
					 if(elementTable[x][y] != null){
						 try{
							 Image img1 = ImageIO.read(new File(elementTable[x][y].skin));
							 g.drawImage(img1, elementTable[x][y].getPosx()*40,
									elementTable[x][y].getPosy()*40, this);
						 }catch (IOException e){
							 e.printStackTrace();
							 
						 }
						 catch (NullPointerException e){
							 System.out.println("osef");
						 }
					 }
				 }
			 }
			 // Pour le tableau a coté
			 gameWindow.updateLabel();
		}
	}
}
