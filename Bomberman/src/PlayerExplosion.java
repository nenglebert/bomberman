
// La classe qui contient la méthode qui gère l'explosion du joueur
public class PlayerExplosion implements IExplosion {

	public void explose(int posx, int posy, Board board) {
		int playerNumber = board.getPlayerNumber();
		Player[] playerList = GamePanel.getPlayerList();
		int i=0;
		while (i < playerNumber && (playerList[i].getPosx() != posx || playerList[i].getPosy() != posy)){
			i++;
		}
		playerList[i].setLife(playerList[i].getLife()-1);
		System.out.println("Pour le joueur "+String.valueOf(i+1)+", il reste "+playerList[i].getLife()+" vie(s)");
	if (playerList[i].getLife()==0)
		System.out.println("Le joueur "+String.valueOf(i+1)+" est mort");
	
	}
}
