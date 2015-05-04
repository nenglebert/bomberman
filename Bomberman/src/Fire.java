import java.util.Timer;
import java.util.TimerTask;


public class Fire extends Element{
	
		// Nos flammes
	public Fire(String skin, final int posx, final int posy, final Board board, final Player player){
		this.skin = skin;
		this.explosion = new DeleteExplosion();
		this.posx = posx;
		this.posy = posy;
		final String ref = toString();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			  public void run() {				  
				if (board.getElemInBoard(posx, posy) != null && board.getElemInBoard(posx, posy).toString().equals(ref))
				applyExplose(board, player);
					  }										
					}, 1050); 
	}
}

