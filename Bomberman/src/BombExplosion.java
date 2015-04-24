import java.util.Timer;
import java.util.TimerTask;


// La classe qui va contenir la méthode qui gère l'explosion de la bombe
public class BombExplosion implements IExplosion{
	
	public void explose(final int posx, final int posy, final Board board) {
		// Création de chaque objet flamme (par case, centrale, horizontale, verticale)
		Fire fireCenter = new Fire("explosionCentre.jpg",posx,posy);
				
		Timer timer = new Timer();
				
		// Et la on fait apparaitre les flammes après conditions
		board.setElemInBoard(posx,posy,fireCenter);
		// Pour que les cases disparaissent
		timer.schedule(new TimerTask() {
			  public void run() {
				  board.setElemInBoard(posx,posy,null);
					  }										
					}, 1000); 
				
				if ((posx+1) <= 14 && !(board.getElemInBoard(posx+1,posy) instanceof Bedrock)){
					board.setElemInBoard(posx+1,posy,new Fire("explosionHor.jpg",posx+1,posy));
					
					timer.schedule(new TimerTask() {
						  public void run() {
							  board.setElemInBoard(posx+1,posy,null);
						  }										
						}, 1000);
				}
				if (0 <= (posx-1) && !(board.getElemInBoard(posx-1,posy) instanceof Bedrock)){
					board.setElemInBoard(posx-1,posy,new Fire("explosionHor.jpg",posx-1,posy));
					
					timer.schedule(new TimerTask() {
						  public void run() {
							  board.setElemInBoard(posx-1,posy,null);
						  }										
						}, 1000);
				}
				if ((posy+1) <= 14 && !(board.getElemInBoard(posx,posy+1) instanceof Bedrock)){
					board.setElemInBoard(posx,posy+1,new Fire("explosionVert.jpg",posx,posy+1));
					
					timer.schedule(new TimerTask() {
						  public void run() {
							  board.setElemInBoard(posx,posy+1,null);
						  }										
						}, 1000);
				}
				if (0 <= (posy-1) && !(board.getElemInBoard(posx,posy-1) instanceof Bedrock)){
					board.setElemInBoard(posx,posy-1,new Fire("explosionVert.jpg",posx,posy-1));
					
					timer.schedule(new TimerTask() {
						  public void run() {
							  board.setElemInBoard(posx,posy-1,null);
						  }										
						}, 1000);		
				}
				
			}

}
