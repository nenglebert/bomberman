
	// Classe abstraite dont hérite tous les éléments du plateau
public class Element {
	
		// Initialisation des attributs communs à tous les éléments
	protected String skin;
	protected IExplosion explosion;
	protected int posx;
	protected int posy;
		
		// Méthode qui permet d'appeler la méthode explose 
		// des attributs explosion des sous-classes
	public void applyExplose(Board board){
		explosion.explose(this.posx, this.posy, board);
	}
		
		// Tous les gettteurs
	public String getSkin(){
		return skin;
	}
	
	public int getPosx(){
		return posx;
	}
		
	public int getPosy(){
		return posy;
	}
		
		// Tous les setteurs
	public void setSkin(String skin){
		this.skin = skin;
	}
		
	public void setPosx(int posx){
		this.posx = posx;
	}
		
	public void setPosy(int posy){
		this.posy = posy;
	}
		
}