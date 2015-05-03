import java.util.Timer;
import java.util.TimerTask;


// La classe qui va contenir la méthode qui gère l'explosion de la bombe
public class BombExplosion implements IExplosion{
	
	public void explose(final int posx, final int posy, final Board board, final Player player) {
		Fire fireCenter = new Fire("explosionCentre.jpg",posx,posy, board, player);
		Timer timer = new Timer();
		int bombSize = player.getBombSize();
				
		// Et la on fait apparaitre les flammes après conditions
		board.setElemInBoard(posx,posy,fireCenter);
		// Pour que les cases disparaissent
		
			for (int i=1; i<=bombSize; i++){
				if ((posx+i) <= 14 && !(board.getElemInBoard(posx+i,posy) instanceof Bedrock)){
					Element CurrentElem1 = board.getElemInBoard(posx+i,posy);
					board.setElemInBoard(posx+i,posy,new Fire("explosionHor.jpg",posx+i,posy,board, player));
					if (CurrentElem1 != null && !(CurrentElem1 instanceof Fire))
					CurrentElem1.applyExplose(board, player);
				}
				if (0 <= (posx-i) && !(board.getElemInBoard(posx-i,posy) instanceof Bedrock)){
					Element CurrentElem1 = board.getElemInBoard(posx-i,posy);
					board.setElemInBoard(posx-i,posy,new Fire("explosionHor.jpg",posx-i,posy,board, player));
					if (CurrentElem1 != null && !(CurrentElem1 instanceof Fire))
					CurrentElem1.applyExplose(board, player);
				}
				if ((posy+i) <= 14 && !(board.getElemInBoard(posx,posy+i) instanceof Bedrock)){
					Element CurrentElem1 = board.getElemInBoard(posx,posy+i);
					board.setElemInBoard(posx,posy+i,new Fire("explosionVert.jpg",posx,posy+i,board, player));
					if (CurrentElem1 != null && !(CurrentElem1 instanceof Fire))
					CurrentElem1.applyExplose(board, player);
				}
				if (0 <= (posy-i) && !(board.getElemInBoard(posx,posy-i) instanceof Bedrock)){
					Element CurrentElem1 = board.getElemInBoard(posx,posy-i);
					board.setElemInBoard(posx,posy-i,new Fire("explosionVert.jpg",posx,posy-i,board, player));
					if (CurrentElem1 != null && !(CurrentElem1 instanceof Fire))
					CurrentElem1.applyExplose(board, player);
					
					
				}
			}
				board.getPanel().update();
				timer.schedule(new TimerTask() {
					  public void run() {	
						 for (int i=0;i<board.getPlayerNumber();i++){
							 for (int j=1; j<=player.getBombSize(); j++){
								 if((board.getPlayer(i).getPosx() == posx && board.getPlayer(i).getPosy()==posy) || (board.getPlayer(i).getPosx() == posx+j && board.getPlayer(i).getPosy()==posy) || (board.getPlayer(i).getPosx() == posx-j && board.getPlayer(i).getPosy()==posy) || (board.getPlayer(i).getPosx() == posx && board.getPlayer(i).getPosy()==posy-j) || (board.getPlayer(i).getPosx() == posx && board.getPlayer(i).getPosy()==posy+j))
									 board.setElemInBoard(board.getPlayer(i).getPosx(), board.getPlayer(i).getPosy(), board.getPlayer(i));
						  board.getPanel().update();
							 } 
						 }		
					  }								
				 }, 1050);
					 
				
			}

}
