import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

	// Plateau de jeu mis sous matrice
public class Board {
	
	private Element[][] elementTable = new Element[15][15];
	private Player[] playerList;
	private int playerNumber;
	private GamePanel panel;
	private int playerDeath = 0;
	private GameWindow gameWindow;
	
		// Constructeur par défaut
	public Board(Player[] playerList, GamePanel panel, GameWindow gameWindow){
		this.gameWindow = gameWindow;
		this.panel = panel;
			// On récupère les personages 
		this.playerList = playerList;
		this.playerNumber = playerList.length;
		
			//Placement des blocs incassables
		for (int x=1; x < elementTable.length; x+=2){
			for (int y=1; y < elementTable.length; y+=2){
				elementTable[x][y] = new Bedrock(x,y);
			}
		}
			//Placement des blocs cassables
		for (int x=0; x < elementTable.length; x++){
			for (int y=0; y < elementTable.length; y++){
					
					//On augmente la probabilité si on est dans une ligne
					//ou des bedrocks sont présents
				double proba;
				if (x%2 != 1)
					proba = 0.4;
				else
					proba = 0.5;
					
				if(elementTable[x][y] == null && Math.random() >= proba)
					elementTable[x][y] = new Block(x,y);
			}
		}
			
			//Place les cases libres
		elementTable[0][0]  = elementTable[0][1]   = elementTable[1][0]   = elementTable[0][13]  = 
		elementTable[0][14] = elementTable[1][14]  = elementTable[13][0]  = elementTable[14][0]  = 
		elementTable[14][1] = elementTable[14][13] = elementTable[14][14] = elementTable[13][14] =
		null;
		
			//Place les joueurs
		int[] posxList = {0,14,14,0};
		int[] posyList = {0,14,0,14};
		
		for (int i=0; i< playerNumber; i++){
			elementTable[posxList[i]][posyList[i]] = playerList[i];
		}
	}
	
	public Element[][] getTable(){
		return elementTable;
	}
	
	public void setElemInBoard(int posx,int posy,Element a){
		elementTable[posx][posy]=a;
	}
	public Element getElemInBoard(int posx,int posy){
		return elementTable[posx][posy];
	}
	public int getPlayerNumber(){
		return playerNumber;
	}
	public Player getPlayer(int x){
		return playerList[x];
	}

	public GamePanel getPanel() {
		return this.panel;
	}
	public int getPlayerDeath(){
		return this.playerDeath;
	}
	public void addPlayerDeath(){
		this.playerDeath++;
	}
	public void end(){
		System.out.println("Jeu terminé");
		int i = 0;
		while (playerList[i].getPosx() == -10 ) {
			i++	;	
		}
		JOptionPane dialog = new JOptionPane();
		 UIManager UI=new UIManager();
		 UI.put("OptionPane.background", Color.white);
		 UI.put("Panel.background", Color.white);
		ImageIcon img = new ImageIcon("winner.jpeg");
		dialog.showMessageDialog(null, "The winner is " + playerList[i].getName(), "The end !", JOptionPane.INFORMATION_MESSAGE, img);
		System.out.println(playerList[i].getName()+" a gagné");
		panel.getSound().stopClip();
		gameWindow.getContentPane().removeAll();
		gameWindow.dispose();
		System.gc();
	}
}
