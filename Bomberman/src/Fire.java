import java.util.Timer;
import java.util.TimerTask;


public class Fire extends Element{
	
		// Nos flammes
	public Fire(String skin, int posx, int posy, Board board){
		this.skin = skin;
		this.explosion = new DeleteExplosion();
		this.posx = posx;
		this.posy = posy;
		String ref = toString();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			  public void run() {				  
				if (board.getElemInBoard(posx, posy) != null && board.getElemInBoard(posx, posy).toString().equals(ref))
				applyExplose(board);
					  }										
					}, 1000); 
	}
}

