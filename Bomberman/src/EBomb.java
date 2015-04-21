import java.util.Timer;
import java.util.TimerTask;


public class EBomb implements Explose {
	
	public void explose(final Panneau pan, final int posx, final int posy) {
		
		// Création de chaque objet flamme (par case, centrale, horizontale, verticale)
		Fire fireCenter = new Fire("explosionCentre.jpg",posx,posy);
		Fire fireH1 = new Fire("explosionHor.jpg",posx+1,posy);
		Fire fireH2 = new Fire("explosionHor.jpg",posx-1,posy);
		Fire fireV1 = new Fire("explosionVert.jpg",posx,posy+1);
		Fire fireV2 = new Fire("explosionVert.jpg",posx,posy-1);
		
		Timer timer = new Timer();
		
		// Et la on fait apparaitre les flammes après conditions
		pan.board.table[posx][posy] = fireCenter;
		// Pour que les cases disparaissent
		timer.schedule(new TimerTask() {
			  public void run() {
				  pan.board.table[posx][posy] = null;
			  }										
			}, 1000);
		
		if (posx+1 <= 14 && !(pan.board.table[posx+1][posy] instanceof Bedrock)){
			pan.board.table[posx+1][posy] = fireH1;
			
			timer.schedule(new TimerTask() {
				  public void run() {
					  pan.board.table[posx+1][posy] = null;
				  }										
				}, 1000);
		}
		if (0 <= posx-1 && !(pan.board.table[posx-1][posy] instanceof Bedrock)){
			pan.board.table[posx-1][posy] = fireH2;
			
			timer.schedule(new TimerTask() {
				  public void run() {
					  pan.board.table[posx-1][posy] = null;
				  }										
				}, 1000);
		}
		if (posy+1 <= 14 && !(pan.board.table[posx][posy+1] instanceof Bedrock)){
			pan.board.table[posx][posy+1] = fireV1;
			
			timer.schedule(new TimerTask() {
				  public void run() {
					  pan.board.table[posx][posy+1] = null;
				  }										
				}, 1000);
		}
		if (0 <= posy-1 && !(pan.board.table[posx][posy-1] instanceof Bedrock)){
			pan.board.table[posx][posy-1] = fireV2;
			
			timer.schedule(new TimerTask() {
				  public void run() {
					  pan.board.table[posx][posy-1] = null;
				  }										
				}, 1000);
		}
	}

}
