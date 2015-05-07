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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePanel extends JPanel implements KeyListener{
	//Création des différents objets
	private Board board;
	private Element[][] elementTable;
	protected static Player[] playerList;
	private int playerNumber;
	private Map<Integer,Tuple<Integer,Direction,Image>> commandKeys = new HashMap<Integer,Tuple<Integer, Direction,Image>>();
	
	// Interface JPanel (conteneur de boutons)
	private JPanel subPanel = new JPanel();	
	
	private JButton startButton = new JButton("Start game");	//Bouton "Start"
	private JButton tutoButton = new JButton("Tutorial");		//Bouton "Tutorial"
	private JButton player2Button = new JButton("2 Players");	//Bouton "2 players"
	private JButton player3Button = new JButton("3 Players");	//Bouton "3 players"
	private JButton player4Button = new JButton("4 Players");	//Bouton "4 players"
	private JButton validateButton = new JButton("Validate");	//Bouton "Validate"
	
	// Gestion des labels	
	private JLabel introLabel = new JLabel("Take up the challenge and play !");
	private JLabel playerLabel = new JLabel("Choose the number of player");
	private JLabel nameLabel = new JLabel("Enter the players name");
	
	private ArrayList<JTextField> nameFields = new ArrayList<JTextField>();	//Zone pour les noms
	private ArrayList<String> nameList = new ArrayList<String>();
	
	//Affichage du menu
	private int begin = 0;	// Indique qu'il faut afficher le menu
	private GameWindow gameWindow;
	public enum Direction{UP,DOWN,LEFT,RIGHT,BOMB};
	private Element[][] oldElementTable;
	private Sound sound;
	private ArrayList<ArrayList<Image>> skin = new ArrayList<ArrayList<Image>>();
	private File nukeSound = new File("nuke.wav");
	private File playback = new File("test.wav");
	private Image whiteSquare = ImageIO.read(getClass().getResource("blanc.jpeg"));
	public GamePanel(GameWindow gameWindow) throws IOException{
		this.gameWindow = gameWindow;
		this.initialize();
		this.addKeyListener(this);
		this.setFocusable(true);
	}

	public void initialize() throws IOException {
		commandKeys.put(KeyEvent.VK_Z, new Tuple<Integer, Direction,Image>(0,Direction.UP,ImageIO.read(getClass().getResource("skin1_h.png"))));
		commandKeys.put(KeyEvent.VK_Q, new Tuple<Integer, Direction,Image>(0,Direction.LEFT,ImageIO.read(getClass().getResource("skin1_g.png"))));
		commandKeys.put(KeyEvent.VK_S, new Tuple<Integer, Direction,Image>(0,Direction.DOWN,ImageIO.read(getClass().getResource("skin1.png"))));
		commandKeys.put(KeyEvent.VK_D, new Tuple<Integer, Direction,Image>(0,Direction.RIGHT,ImageIO.read(getClass().getResource("skin1_d.png"))));
		commandKeys.put(KeyEvent.VK_UP, new Tuple<Integer, Direction,Image>(1,Direction.UP,ImageIO.read(getClass().getResource("skin2_h.png"))));
		commandKeys.put(KeyEvent.VK_LEFT, new Tuple<Integer, Direction,Image>(1,Direction.LEFT,ImageIO.read(getClass().getResource("skin2_g.png"))));
		commandKeys.put(KeyEvent.VK_DOWN, new Tuple<Integer, Direction,Image>(1,Direction.DOWN,ImageIO.read(getClass().getResource("skin2.png"))));
		commandKeys.put(KeyEvent.VK_RIGHT, new Tuple<Integer, Direction,Image>(1,Direction.RIGHT,ImageIO.read(getClass().getResource("skin2_d.png"))));
		commandKeys.put(KeyEvent.VK_I, new Tuple<Integer, Direction,Image>(2,Direction.UP,ImageIO.read(getClass() .getResource("skin3_h.png"))));
		commandKeys.put(KeyEvent.VK_J, new Tuple<Integer, Direction,Image>(2,Direction.LEFT,ImageIO.read(getClass().getResource("skin3_g.png"))));
		commandKeys.put(KeyEvent.VK_K, new Tuple<Integer, Direction,Image>(2,Direction.DOWN,ImageIO.read(getClass().getResource("skin3.png"))));
		commandKeys.put(KeyEvent.VK_L, new Tuple<Integer, Direction,Image>(2,Direction.RIGHT,ImageIO.read(getClass().getResource("skin1_d.png"))));
		commandKeys.put(KeyEvent.VK_G, new Tuple<Integer, Direction,Image>(3,Direction.UP,ImageIO.read(getClass().getResource("skin4_h.png"))));
		commandKeys.put(KeyEvent.VK_V, new Tuple<Integer, Direction,Image>(3,Direction.LEFT,ImageIO.read(getClass().getResource("skin4_g.png"))));
		commandKeys.put(KeyEvent.VK_B, new Tuple<Integer, Direction,Image>(3,Direction.DOWN,ImageIO.read(getClass().getResource("skin4.png"))));
		commandKeys.put(KeyEvent.VK_N, new Tuple<Integer, Direction,Image>(3,Direction.RIGHT,ImageIO.read(getClass().getResource("skin4_d.png"))));
		commandKeys.put(KeyEvent.VK_A, new Tuple<Integer, Direction,Image>(0,Direction.BOMB,ImageIO.read(getClass().getResource("bomb1.png"))));
		commandKeys.put(KeyEvent.VK_U, new Tuple<Integer, Direction,Image>(2,Direction.BOMB,ImageIO.read(getClass().getResource("bomb2.png"))));
		commandKeys.put(KeyEvent.VK_F, new Tuple<Integer, Direction,Image>(3,Direction.BOMB,ImageIO.read(getClass().getResource("bomb3.png"))));
		commandKeys.put(KeyEvent.VK_ENTER, new Tuple<Integer, Direction,Image>(1,Direction.BOMB,ImageIO.read(getClass().getResource("bomb4.png"))));
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
		subPanel.setOpaque(false);		//Mise en forme des boutons
		this.add(subPanel);				//Placement sur la fenêtre
		
		this.setPreferredSize(new Dimension(600, 600));
		
		// Boutons
		startButton.addActionListener(new StartActionListener(this,subPanel));
		player2Button.addActionListener(new PlayerActionListener(this,subPanel,2));
		player3Button.addActionListener(new PlayerActionListener(this,subPanel,3));
		player4Button.addActionListener(new PlayerActionListener(this,subPanel,4));
	}
	
/////////////////

	//Gestion des touches
	public void keyPressed(KeyEvent e){
	if (begin == 1 || begin == 2){	
		Tuple<Integer,Direction,Image> playerAction = commandKeys.get(e.getKeyCode());
		if(playerAction == null || playerAction.first()+1>playerNumber)
			return;
		if (playerList[playerAction.first()].getLife()==0){
			commandKeys.remove(e.getKeyCode());
			return;
		}
		if (playerAction.second().equals(Direction.UP) && check(playerList[playerAction.first()].getPosx(),playerList[playerAction.first()].getPosy()-1,playerAction.first())){
			playerList[playerAction.first()].setSkin(playerAction.third());
			if (!(board.getElemInBoard(playerList[playerAction.first()].getPosx(), playerList[playerAction.first()].getPosy()) instanceof Bomb))
			board.setElemInBoard(playerList[playerAction.first()].getPosx(), playerList[playerAction.first()].getPosy(), null);
			board.setElemInBoard(playerList[playerAction.first()].getPosx(), playerList[playerAction.first()].getPosy()-1, playerList[playerAction.first()]);
			playerList[playerAction.first()].setPosy(playerList[playerAction.first()].getPosy()-1);
			update();
		}
		else if(playerAction.second().equals(Direction.DOWN) && check(playerList[playerAction.first()].getPosx(),playerList[playerAction.first()].getPosy()+1,playerAction.first())){
			playerList[playerAction.first()].setSkin(playerAction.third());
			if (!(board.getElemInBoard(playerList[playerAction.first()].getPosx(), playerList[playerAction.first()].getPosy()) instanceof Bomb))
			board.setElemInBoard(playerList[playerAction.first()].getPosx(), playerList[playerAction.first()].getPosy(), null);
			board.setElemInBoard(playerList[playerAction.first()].getPosx(), playerList[playerAction.first()].getPosy()+1, playerList[playerAction.first()]);
			playerList[playerAction.first()].setPosy(playerList[playerAction.first()].getPosy()+1);
			update();
		}
		else if(playerAction.second().equals(Direction.LEFT)  && check(playerList[playerAction.first()].getPosx()-1,playerList[playerAction.first()].getPosy(),playerAction.first())){
			playerList[playerAction.first()].setSkin(playerAction.third());
			if (!(board.getElemInBoard(playerList[playerAction.first()].getPosx(), playerList[playerAction.first()].getPosy()) instanceof Bomb))
			board.setElemInBoard(playerList[playerAction.first()].getPosx(), playerList[playerAction.first()].getPosy(), null);
			board.setElemInBoard(playerList[playerAction.first()].getPosx()-1, playerList[playerAction.first()].getPosy(), playerList[playerAction.first()]);
			playerList[playerAction.first()].setPosx(playerList[playerAction.first()].getPosx()-1);
			update();
		}
		else if(playerAction.second().equals(Direction.RIGHT) && check(playerList[playerAction.first()].getPosx()+1,playerList[playerAction.first()].getPosy(),playerAction.first())){
			playerList[playerAction.first()].setSkin(playerAction.third());
			if (!(board.getElemInBoard(playerList[playerAction.first()].getPosx(), playerList[playerAction.first()].getPosy()) instanceof Bomb))
			board.setElemInBoard(playerList[playerAction.first()].getPosx(), playerList[playerAction.first()].getPosy(), null);
			board.setElemInBoard(playerList[playerAction.first()].getPosx()+1, playerList[playerAction.first()].getPosy(), playerList[playerAction.first()]);
			playerList[playerAction.first()].setPosx(playerList[playerAction.first()].getPosx()+1);
			update();
		}
		else if(playerAction.second().equals(Direction.BOMB) && playerList[playerAction.first()].getBombBag() > 0 && !(board.getElemInBoard(playerList[playerAction.first()].getPosx(),playerList[playerAction.first()].getPosy()) instanceof Bomb)){
			playerList[playerAction.first()].setBombBag(playerList[playerAction.first()].getBombBag()-1);
			gameWindow.updateLabel();
			board.setElemInBoard(playerList[playerAction.first()].getPosx(),playerList[playerAction.first()].getPosy(),new Bomb(playerList[playerAction.first()].getPosx(),playerList[playerAction.first()].getPosy(),board,playerList[playerAction.first()],playerAction.third()));
			update();
			
		}
	}	
}	// Fin de keyPressed
	
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	


	//Vérification des collisons et ajout bonus
	public boolean check(int pX, int pY, int pPlayer){
		boolean verif = true;
		if (-1<pX && pX<15 && -1< pY && pY <15 && (board.getElemInBoard(pX,pY) == null || board.getElemInBoard(pX, pY) instanceof Bonus)){
			//Si c'est un bonus, on lui donne
			if(board.getElemInBoard(pX, pY) instanceof Bonus)
				verif = bonus(pX,pY,pPlayer);
		}
		else
			verif = false;
		return verif;
	}
		
	// Fonction bonus. Renvoie True, sauf pour une téléportation.
	public boolean bonus(int pX, int pY, int pPlayer){
		// On caste pour utiliser getType()
		Bonus boni = (Bonus)board.getElemInBoard(pX, pY);
		boolean verif = true;
		
		//Bonus bombe
		if(boni.getType() == 1)
			playerList[pPlayer].setBombBag(playerList[pPlayer].getBombBag()+1);	
			
		
		//Bonus vie
		if(boni.getType() == 2)
			playerList[pPlayer].setLife(playerList[pPlayer].getLife()+1);	
	
		//Bonus taille bombe
		if(boni.getType() == 3)
			playerList[pPlayer].setBombSize(playerList[pPlayer].getBombSize()+1);
		
		//Bonus bombe atomique
		if(boni.getType() == 4){
			Sound nukesound = new Sound(nukeSound,false);
			Thread t3 = new Thread(nukesound);
			sound.pause();
			t3.start();
			int duration = nukesound.getDuration();
			Timer timer = new Timer();
			final int nPlayer = pPlayer;
			timer.schedule(new TimerTask() {
				  public void run() {	
					  for (int i=0; i<playerList.length; i++){
							if (playerList[i] != playerList[nPlayer] && playerList[i].getLife()>0)
								playerList[i].applyExplose(board, playerList[i]);
						}
					 }
				  }, 4000);
			timer.schedule(new TimerTask() {
				  public void run() {	
					  sound.restart();
					 }
				  }, duration+200);
			}
		
		//Bonus téléportation
		if(boni.getType() == 5){
			ArrayList<Integer> posxList = new ArrayList<Integer>();
			ArrayList<Integer> posyList = new ArrayList<Integer>();
			for (int i=0; i<=14; i++){
				for (int j=0; j<=14; j++){
					if (elementTable[i][j] == null){
						posxList.add(i);
						posyList.add(j);
					}
				}
			}
			// Choisi une position au hasard.
			Random random = new Random();
			int randomNumber = random.nextInt(posxList.size());
			board.setElemInBoard(playerList[pPlayer].getPosx(), playerList[pPlayer].getPosy(), null);
			board.setElemInBoard(pX, pY,null);
			playerList[pPlayer].setPosx(posxList.get(randomNumber));
			playerList[pPlayer].setPosy(posyList.get(randomNumber));
			board.setElemInBoard(playerList[pPlayer].getPosx(),playerList[pPlayer].getPosy(),playerList[pPlayer]);
			verif = false; //Ne bouge pas après la téléportation
			update();
		}
		gameWindow.updateLabel();
		return verif;
	}




	//Touche lachée
	public void keyReleased(KeyEvent e){}

	//Par ex : CTRL + touch
	public void keyTyped(KeyEvent e){}
	
	public void playerChooseWindow(JPanel subPanel){
		//Fait apparaître la page 2 (nombre de joueur)
		subPanel.removeAll();
		subPanel.setLayout(new GridLayout(4,1));
		
		subPanel.add(playerLabel);
		subPanel.add(player2Button);
		subPanel.add(player3Button);
		subPanel.add(player4Button);

		subPanel.revalidate();
	}
	
	//Récupère le nom des joueurs.
	public void takePlayersName(JPanel subPanel, int playerNumber){
		subPanel.removeAll();
		subPanel.setLayout(new GridLayout(2*playerNumber + 2,1));
		
		subPanel.add(nameLabel);
		// Création des espaces d'ériture du nom
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
	
	// Crée et place les joueurs
	public void createPlayers(int playerNumber) throws IOException{
		int[] keyForSkin = {KeyEvent.VK_S,KeyEvent.VK_DOWN,KeyEvent.VK_K,KeyEvent.VK_B};
		this.playerNumber = playerNumber;
		int[] posxList = {0,14,14,0};
		int[] posyList = {0,14,0,14};
		playerList = new Player[playerNumber];
		for (int i=0;i < playerNumber;i++){
			playerList[i] = new Player(commandKeys.get(keyForSkin[i]).third(), nameList.get(i), posxList[i], posyList[i]);
		}
		
		subPanel.removeAll();
		this.revalidate();
		board = new Board(playerList,this,gameWindow);
		elementTable = board.getTable();
		begin = 1;
		repaint();
		sound = new Sound(playback,true);
		Thread t1 = new Thread(sound);
		t1.start();
		
		
	}
	
	//Les getteurs
	public String getName(int number){
		return nameList.get(number);
	}
	
	public static Player[] getPlayerList(){
		return playerList;
	}
	
	public Board getBoard(){
		return board;
	}
	
	
	//Les setteurs
	public void setName(String name){
		this.nameList.add(name);
	}
	
	public void resetName(){
		this.nameList.clear();
	}
	
	// Rafraichi la fenêtre
	public void update(){  
	   
		this.begin = 2;
		this.paintComponent(this.getGraphics());
		//repaint();
	}
	
	//Permet la "deepcopy" de la matrice
	public Element[][] dcopy(Element[][] input) {
	    Element[][] target = new Element[input.length][];
	    for (int i=0; i <input.length; i++) {
	      target[i] = Arrays.copyOf(input[i], input[i].length);
	    }
	    return target;
	}
	

	//Affichage
	public void paintComponent(Graphics g){
		
		//Ecran d'accueil
		if (begin==0){
		ImageIcon img = new ImageIcon(getClass().getResource("Background.jpg"));
		super.paintComponent(g); 
		img.paintIcon(this, g, 0, 0);
		}
		// Seulement pour le premier affichage
		
		// Premier affichage : charge l'intégralité du plateau
		else if(begin==1) {
			this.setLayout(new GridLayout(1,2));
			super.paintComponent(g); 
			this.setBackground(Color.white);
			 
			 // Passe la grille en revue & place les éléments
			 for(int x = 0; x < elementTable.length; x++){
				 for(int y = 0; y < elementTable.length; y++){
					 if(elementTable[x][y] != null){
						 try{
							 Image img1 = elementTable[x][y].getSkin();
							 g.drawImage(img1, elementTable[x][y].getPosx()*40,
									elementTable[x][y].getPosy()*40, this);

						 }catch (NullPointerException e){
							 System.out.println("Méchant NullPointerExeption !");
						 }
					 }
				 }
			 }
			 
		// Pour le tableau latéral
		gameWindow.updateLabel();
		
		// Copie plateau de jeu
		oldElementTable = dcopy(elementTable);
		return;
		}
		
		// Ne redessine que les modifications en comparants les changements
		// avec la copie du plateau de jeu précédent.
		else if (begin ==2){
			this.setLayout(new GridLayout(1,2));
			Element [][] newElementTable = dcopy(elementTable);
			for(int x = 0; x < newElementTable.length; x++){
				 for(int y = 0; y < newElementTable.length; y++){
					 
					 // Si les éléments ne sont pas les mêmes dans chaque plateau,
					 // il y a eu modification : on affiche la modification.
					 if(newElementTable[x][y] != null){
						 if (!newElementTable[x][y].equals(oldElementTable[x][y])){
							 try{
						 			Image img1 = newElementTable[x][y].getSkin();
						 			g.drawImage(img1, newElementTable[x][y].getPosx()*40,
						 					newElementTable[x][y].getPosy()*40, this);
						 		}catch (NullPointerException e){
						 			System.out.println("Méchant NullPointerExeption !");
						 		}							 
						 }
					 }
					 
					 // Si l'ancien élément n'est pas null mais que le nouveau 
					 // l'est, on redessine une case blanche dessus.
					 else if(oldElementTable[x][y]!=null) {
						 try{
					 			g.drawImage(whiteSquare, x*40, y*40, this);
					 		}
					 		catch (NullPointerException e){
					 			System.out.println("Méchant NullPointerExeption !");
					 		}						 
					 }
				}
			}
		oldElementTable = dcopy(newElementTable); 
		return;
		}
	}
	public Sound getSound(){
	return sound;
	}
}
