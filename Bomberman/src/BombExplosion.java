import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

// Défini la méthode explose() pour les élements de type "Bomb".
// Elle cause la suppression des blocs touchés et l'apparition 
// de flamme (voir classe Fire) à ces endroits.

// La classe qui va contenir la méthode qui gère l'explosion de la bombe
public class BombExplosion  implements IExplosion {
	public void explose(final int posx, final int posy, final Board board, final Player player){
		Image explosionCentre = board.getFireSkin(0);
		Image explosionHor = board.getFireSkin(2);
		Image explosionVert = board.getFireSkin(1);
		board.getBombSound().play();
		Fire fireCenter = new Fire(explosionCentre,posx,posy, board);
		Timer timer = new Timer();
		int bombSize = player.getBombSize();
		int boardSize = board.getBoardSize();
		// Variables de condition pour que les flammes n'apparaissent pas si la première 
		// case est un objet qui a explosé
		int pass1 = 1;
		int pass2 = 1;
		int pass3 = 1;
		int pass4 = 1;
		
		// Et la on fait apparaitre les flammes après conditions
		
			board.setElemInBoard(posx,posy,fireCenter);
		// Pour que les cases disparaissent
			for (int i=1; i<=bombSize; i++){
				if ((posx+i) <= boardSize && !(board.getElemInBoard(posx+i,posy) instanceof Bedrock) && pass1 == 1){
					Element currentElem1 = board.getElemInBoard(posx+i,posy);
					board.setElemInBoard(posx+i,posy,new Fire(explosionHor,posx+i,posy,board));
					if (currentElem1 != null && !(currentElem1 instanceof Fire)){
						pass1 = 0;
						if (currentElem1 instanceof Bomb)
							((Bomb)currentElem1).ImExploding();
						currentElem1.applyExplose(board);
					}
				}
				
				else if ((posx+i) <= boardSize && board.getElemInBoard(posx+i,posy) instanceof Bedrock) 
				pass1 =0;
				
				if (0 <= (posx-i) && !(board.getElemInBoard(posx-i,posy) instanceof Bedrock) && pass2 == 1){
					Element currentElem1 = board.getElemInBoard(posx-i,posy);
					board.setElemInBoard(posx-i,posy,new Fire(explosionHor,posx-i,posy,board));
					if (currentElem1 != null && !(currentElem1 instanceof Fire)){
						pass2 = 0;
						if (currentElem1 instanceof Bomb)
							((Bomb)currentElem1).ImExploding();
						currentElem1.applyExplose(board);
					}
				}
				
				else if (0 <= (posx-i) && board.getElemInBoard(posx-i,posy) instanceof Bedrock) 
					pass2 =0;
				
				if ((posy+i) <= boardSize && !(board.getElemInBoard(posx,posy+i) instanceof Bedrock) && pass3 == 1){
					Element currentElem1 = board.getElemInBoard(posx,posy+i);
					board.setElemInBoard(posx,posy+i,new Fire(explosionVert,posx,posy+i,board));
					if (currentElem1 != null && !(currentElem1 instanceof Fire)){
						pass3 = 0;
						if (currentElem1 instanceof Bomb)
							((Bomb)currentElem1).ImExploding();
						currentElem1.applyExplose(board);
					}
				}
				
				else if ((posy+i) <= boardSize && board.getElemInBoard(posx,posy+i) instanceof Bedrock) 
					pass3 =0;
				
				if (0 <= (posy-i) && !(board.getElemInBoard(posx,posy-i) instanceof Bedrock) && pass4 == 1){
					Element currentElem1 = board.getElemInBoard(posx,posy-i);
					board.setElemInBoard(posx,posy-i,new Fire(explosionVert,posx,posy-i,board));
					if (currentElem1 != null && !(currentElem1 instanceof Fire)){
						pass4 = 0;
						if (currentElem1 instanceof Bomb)
							((Bomb)currentElem1).ImExploding();
						currentElem1.applyExplose(board);
					}	
				}
				
				else if (0 <= (posy-i) && board.getElemInBoard(posx,posy-i) instanceof Bedrock) 
					pass4 =0;
			}
			if (player.getPosx() == posx && player.getPosy() == posy)
				player.applyExplose(board);
				board.getPanel().update();
				timer.schedule(new TimerTask() {
					  public void run() {	
						 for (int i=0;i<board.getPlayerNumber();i++){
							 for (int j=1; j<=player.getBombSize(); j++){
								 if((board.getPlayer()[i].getPosx() == posx && board.getPlayer()[i].getPosy()==posy) || (board.getPlayer()[i].getPosx() == posx+j && board.getPlayer()[i].getPosy()==posy) || (board.getPlayer()[i].getPosx() == posx-j && board.getPlayer()[i].getPosy()==posy) || (board.getPlayer()[i].getPosx() == posx && board.getPlayer()[i].getPosy()==posy-j) || (board.getPlayer()[i].getPosx() == posx && board.getPlayer()[i].getPosy()==posy+j))
									 board.setElemInBoard(board.getPlayer()[i].getPosx(), board.getPlayer()[i].getPosy(), board.getPlayer()[i]);
						  board.getPanel().update();
							 } 
						 }		
					  }								
				 }, 1100);
					 
				
			}

}
