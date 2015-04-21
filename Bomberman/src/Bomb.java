import java.util.Timer;
import java.util.TimerTask;


public class Bomb extends Element {
	// Création du timer
	Timer timer = new Timer();
	
	// On prend pan en argument pour pouvoir l'envoyer 
	// à explose et ainsi modifier la matrice
	public Bomb(final int posx, final int posy, final Panneau pan){
		this.skin = "bomb.png";
		this.explose = new EBomb(); 	// L'explosion selon Bomb
		this.posx = posx;
		this.posy = posy;
		this.life = 1;
		
		// La bombe explosera dans une seconde grâce au timer
		timer.schedule(new TimerTask() {
			  public void run() {
				  applyExplose(pan,posx,posy);		// Méthode de Element qui 
			  }										// Appelle les vrais méthode Explose
			}, 1000);
	}
}
