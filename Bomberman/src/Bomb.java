import java.util.Timer;
import java.util.TimerTask;


	// La bombe
public class Bomb extends Element {
	
	Timer timer = new Timer();
	
	public Bomb(int posx, int posy, Board board){
		this.skin = "bomb.png";
		this.explosion = new BombExplosion(); 	// L'explosion selon Bomb
		this.posx = posx;
		this.posy = posy;
		
		// La bombe explosera dans une seconde grâce au timer
		timer.schedule(new TimerTask() {
			public void run() {
				applyExplose(posx,posy,board);	
						 		// Méthode de Element qui 
			}					// Appelle les vrais méthode Explose
		}, 1000);
	}
}
