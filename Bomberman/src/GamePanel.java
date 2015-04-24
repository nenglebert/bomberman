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

public class GamePanel extends JPanel implements KeyListener{
	
		// Création des différents objets
	private Board board;
	private Element[][] elementTable;
	private ArrayList<Player> playerList = new ArrayList<Player>();
	private int playerNumber;
	
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
	
	private int xelem;
	private int yelem;
	private Element elem;
	private int begin = 0;	// ces deux suivants servent à paint
	
	public GamePanel(){
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
		
		//On prépare le premier affichage
		subPanel.add(introLabel);
		subPanel.add(startButton);
		subPanel.add(tutoButton);
		subPanel.setOpaque(false);		//C'est pour ne pas avoir de bouton dégueu
		this.add(subPanel);				//On met tout sur notre panel générale
		
		this.setPreferredSize(new Dimension(600, 600));
		
		//Définissions des boutons
		startButton.addActionListener(new StartActionListener(this,subPanel));
		player2Button.addActionListener(new PlayerActionListener(this,subPanel,2));
		player3Button.addActionListener(new PlayerActionListener(this,subPanel,3));
		player4Button.addActionListener(new PlayerActionListener(this,subPanel,4));
	}
	
/////////////////
//Lorsqu'une touche est appuyée
//Le check permet de ne rien faire si un block est la ou on
//veut aller
	public void keyPressed(KeyEvent e){

// Joueur 1
	int x1 = playerList.get(0).getPosx();
	int y1 = playerList.get(0).getPosy();
	
	System.out.println(x1 + " " + y1);
	if(e.getKeyCode()==KeyEvent.VK_RIGHT && x1 < 14)
		if(check(x1+1,y1)){
			playerList.get(0).setPosx(x1+1);
			if (!(board.getElemInBoard(x1, y1) instanceof Bomb))
			board.setElemInBoard(x1, y1, null);
			board.setElemInBoard(x1+1, y1, playerList.get(0));
		}

	if(e.getKeyCode()==KeyEvent.VK_LEFT && x1 > 0)
		if(check(x1-1,y1)){
			playerList.get(0).setPosx(x1-1);
			if (!(board.getElemInBoard(x1, y1) instanceof Bomb))
			board.setElemInBoard(x1, y1, null);
			board.setElemInBoard(x1-1, y1, playerList.get(0));
		}
	if(e.getKeyCode()==KeyEvent.VK_UP && y1 > 0)
		if(check(x1,y1-1)){
			playerList.get(0).setPosy(y1-1);
			if (!(board.getElemInBoard(x1, y1) instanceof Bomb))
			board.setElemInBoard(x1, y1, null);
			board.setElemInBoard(x1, y1-1, playerList.get(0));
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN && y1 < 14)
		if(check(x1,y1+1)){
			playerList.get(0).setPosy(y1+1);	
			if (!(board.getElemInBoard(x1, y1) instanceof Bomb))
			board.setElemInBoard(x1, y1, null);
			board.setElemInBoard(x1, y1+1, playerList.get(0));
		}
//BOMBAAA
	if(e.getKeyCode()==KeyEvent.VK_SPACE)
		board.setElemInBoard(x1,y1,new Bomb(x1,y1,board));	// Rajout de pan en argument
		// Joueur 1
		int x2 = playerList.get(1).getPosx();
		int y2 = playerList.get(1).getPosy();
		
		if(e.getKeyCode()==KeyEvent.VK_D && x2 < 14)
			if(check(x2+1,y2)){
				playerList.get(1).setPosx(x2+1);
				if (!(board.getElemInBoard(x2, y2) instanceof Bomb))
				board.setElemInBoard(x2, y2, null);
				board.setElemInBoard(x2+1, y2, playerList.get(1));
			}

		if(e.getKeyCode()==KeyEvent.VK_Q && x2 > 0)
			if(check(x2-1,y2)){
				playerList.get(1).setPosx(x2-1);
				if (!(board.getElemInBoard(x2, y2) instanceof Bomb))
				board.setElemInBoard(x2, y2, null);
				board.setElemInBoard(x2-1, y2, playerList.get(1));
			}
		if(e.getKeyCode()==KeyEvent.VK_Z && y2 > 0)
			if(check(x2,y2-1)){
				playerList.get(1).setPosy(y2-1);
				if (!(board.getElemInBoard(x2, y2) instanceof Bomb))
				board.setElemInBoard(x2, y2, null);
				board.setElemInBoard(x2, y2-1, playerList.get(1));
			}
			if(e.getKeyCode()==KeyEvent.VK_S && y2 < 14)
			if(check(x2,y2+1)){
				playerList.get(1).setPosy(y2+1);	
				if (!(board.getElemInBoard(x2, y2) instanceof Bomb))
				board.setElemInBoard(x2, y2, null);
				board.setElemInBoard(x2, y2+1, playerList.get(1));
			}
	//BOMBAAA
		if(e.getKeyCode()==KeyEvent.VK_A)
			board.setElemInBoard(x2,y2,new Bomb(x2,y2, board));	// Rajout de pan en argument
		}

//Check si pas de collision
	public boolean check(int pX, int pY){
		if (board.getElemInBoard(pX,pY) == null)
			return true;
		else
			return false;
}


//Touche lach�e
public void keyReleased(KeyEvent e){}

//Par ex : CTRL + touch
public void keyTyped(KeyEvent e){}
	
	public void playerChooseWindow(JPanel subPanel){
		//Fait apparaître la page 2 (choix du nombre de joueur)
		subPanel.removeAll();
		subPanel.setLayout(new GridLayout(4,1));
		
		subPanel.add(playerLabel);
		subPanel.add(player2Button);
		subPanel.add(player3Button);
		subPanel.add(player4Button);

		subPanel.revalidate();
	}
	
	public void takePlayersName(JPanel subPanel, int playerNumber){
		//Récupère le nom des joueurs
		subPanel.removeAll();
		subPanel.setLayout(new GridLayout(2*playerNumber + 2,1));
		
		subPanel.add(nameLabel);
		// Création des espaces d'écriture du nom
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
		
		for (int i=1;i <= playerNumber;i++){
			playerList.add(new Player("skin"+String.valueOf(i)+".jpeg", nameList.get(i-1), posxList[i-1], posyList[i-1]));
			System.out.println(i + ") " + playerList.get(i-1).getName());
		}
		
		subPanel.removeAll();
		this.revalidate();
		board = new Board(playerList,this);
		elementTable = board.getTable();
		begin = 1;
	}
	
	//Les getteurs
	public String getName(int number){
		return nameList.get(number);
	}
	
	public ArrayList<Player> getPlayerList(){
		return playerList;
	}
	
	
	//Les setteurs
	public void setName(String name){
		this.nameList.add(name);
	}
	
	public void resetName(){
		this.nameList.clear();
	}
	
	public void update(int xelem, int yelem, Element elem){  
		this.xelem = xelem;
		this.yelem = yelem;
		this.elem = elem;
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
			//Plateau de jeu
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
					 }
				 }
			 }
		}
	}
}
