
public class Player extends Element implements IPlayer{
	
	private String name;
	private int speed;
	private int bombBag;
	
	public Player(String name, int posx, int posy){
		//this.skin = ;
		this.explose = new PExplose();
		this.posx = posx;
		this.posy = posy;
		this.life = 5;
		this.name = name;
		this.speed = 1;
		this.bombBag = 1;
	}
	
	// Méthode venant de Element 
	public void applyExplose(){
		explose.explose();
	}
	
	// Méthodes de l'interface à redéfinir
	public void command() {
		
	}
	
	public int getBombBag() {
		return bombBag;
	}
	
	public void setBombBag(int bombBag) {
		this.bombBag = bombBag;
	}

}
