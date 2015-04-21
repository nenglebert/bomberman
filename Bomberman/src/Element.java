
abstract class Element {
	
	// Initialisation des attributs communs à tous les éléments
	protected String skin;
	protected Explose explose;
	protected int posx;
	protected int posy;
	protected int life;
	
	// Méthode qui permet d'appeler la méthode explose des attributs explose des sous-classes
	public void applyExplose(Panneau pan, int posx, int posy){
		explose.explose(pan, posx, posy);
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
	
	public int getLife(){
		return life;
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
	
	public void setLife(int life){
		this.life = life;
	}
}
