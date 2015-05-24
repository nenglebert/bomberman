import java.awt.Image;
import java.io.IOException;


	// Classe abstraite dont hérite tous les éléments du plateau


public abstract class Element {
	
		// Initialisation des attributs communs à tous les éléments
	protected Image skin;
	protected IExplosion explosion;
	protected int posx;
	protected int posy;
	protected Player player;
		
		// Méthode qui permet d'appeler la méthode explose 
		// des attributs explosion des sous-classes
	public void applyExplose(Board board){
		try {
			explosion.explose(this.posx, this.posy, board, this.player);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		// Tous les gettteurs
	public Image getSkin(){
		return skin;
	}
	
	public int getPosx(){
		return posx;
	}
		
	public int getPosy(){
		return posy;
	}
		
		// Tous les setteurs
	public void setSkin(Image skin){
		this.skin = skin;
	}
		
	public void setPosx(int posx){
		this.posx = posx;
	}
		
	public void setPosy(int posy){
		this.posy = posy;
	}
		
}