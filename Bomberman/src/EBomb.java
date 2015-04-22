import java.util.Timer;
import java.util.TimerTask;


public class EBomb implements Explose {
	
	public void explose(final Panneau pan, final int posx, final int posy) {
		
		// Création de chaque objet flamme (par case, centrale, horizontale, verticale)
		Fire fireCenter = new Fire("explosionCentre.jpg",posx,posy);
		
		Timer timer = new Timer();
		
		// Et la on fait apparaitre les flammes après conditions
		pan.setElemInBoard(posx,posy,fireCenter);
		// Pour que les cases disparaissent
		timer.schedule(new TimerTask() {
			  public void run() {
				  pan.setElemInBoard(posx,posy,null);
			  }										
			}, 1000); 
		
		if ((posx+1) <= 14 && !(pan.getElemInBoard(posx+1,posy) instanceof Bedrock)){
			pan.setElemInBoard(posx+1,posy,new Fire("explosionHor.png",posx+1,posy));
			
			timer.schedule(new TimerTask() {
				  public void run() {
					  pan.setElemInBoard(posx+1,posy,null);
				  }										
				}, 1000);
		}
		if (0 <= (posx-1) && !(pan.getElemInBoard(posx-1,posy) instanceof Bedrock)){
			pan.setElemInBoard(posx-1,posy,new Fire("explosionHor.png",posx-1,posy));
			
			timer.schedule(new TimerTask() {
				  public void run() {
					  pan.setElemInBoard(posx-1,posy,null);
				  }										
				}, 1000);
		}
		if ((posy+1) <= 14 && !(pan.getElemInBoard(posx,posy+1) instanceof Bedrock)){
			pan.setElemInBoard(posx,posy+1,new Fire("explosionVert.png",posx,posy+1));
			
			timer.schedule(new TimerTask() {
				  public void run() {
					  pan.setElemInBoard(posx,posy+1,null);
				  }										
				}, 1000);
		}
		if (0 <= (posy-1) && !(pan.getElemInBoard(posx,posy-1) instanceof Bedrock)){
			pan.setElemInBoard(posx,posy-1,new Fire("explosionVert.png",posx,posy-1));
			
			timer.schedule(new TimerTask() {
				  public void run() {
					  pan.setElemInBoard(posx,posy-1,null);
				  }										
				}, 1000);		
		}
		
	}

}
