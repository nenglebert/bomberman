
public class Player extends Element implements IPlayer{
	
	// Attributs propres à Player
	private String name;
	private int speed;
	private int bombBag;
	
	// Constructeur de Player
	public Player(String name, int posx, int posy){
		this.skin = "image1.jpeg";
		this.explose = new PExplose();
		this.posx = posx;
		this.posy = posy;
		this.life = 5;
		this.name = name;
		this.speed = 1;
		this.bombBag = 1;
	}
	
	// Méthodes de l'interface IPlayer à redéfinir
	public void command() {
		
	}
	
	public int getBombBag() {
		return bombBag;
	}
	
	public void setBombBag(int bombBag) {
		this.bombBag = bombBag;
	}

}
