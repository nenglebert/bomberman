import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

//Gère les blocs se détruisant lors d'une explosion
public class Fire extends Element{
	
		// Nos flammes
	public Fire(Image skin, final int posx, final int posy, final Board board){
		this.skin = skin;
		this.explosion = new DeleteExplosion();
		this.posx = posx;
		this.posy = posy;
		final String ref = toString();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			  public void run() {				  
				if (board.getElemInBoard(posx, posy) != null && board.getElemInBoard(posx, posy).toString().equals(ref))
				applyExplose(board);
					  }										
					}, 1050); 
	}
}

