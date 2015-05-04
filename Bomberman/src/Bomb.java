import java.util.Timer;
import java.util.TimerTask;


	// La bombe
public class Bomb extends Element {	
	boolean canIExplose = true;
	public Bomb(final int posx, final int posy, final Board board, final Player pPlayer){
		this.skin = "bomb2.png";
		this.explosion = new BombExplosion(); 	// L'explosion selon Bomb
		this.posx = posx;
		this.posy = posy;	
		// La bombe explosera dans une seconde grâce au timer
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				if (canIExplose){
					ImExploding();
				applyExplose(board, pPlayer);
				if (pPlayer.getPosx() == posx && pPlayer.getPosy() == posy)
					pPlayer.applyExplose(board, pPlayer);
				}
				pPlayer.setBombBag(pPlayer.getBombBag()+1);
				
				
				// Méthode de Element qui 
			}					// Appelle les vrais méthode Explose
		}, 1500);
	}


public void ImExploding(){
	this.canIExplose = false;
}
}