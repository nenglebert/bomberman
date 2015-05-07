import java.awt.Image;


	// Classe de l'élément joueur
public class Player extends Element{

		// Attributs propres à Player
	private String name;
	private int life;
	private int speed;
	private int bombBag;
	private int bombSize;
		
		// Constructeur de Player
	public Player(Image skin, String name, int posx, int posy){
		this.skin = skin;
		this.explosion = new PlayerExplosion();
		this.posx = posx;
		this.posy = posy;
		this.name = name;
		this.life = 3;
		this.speed = 1;
		this.bombBag = 1;
		this.bombSize = 1;
	}
		
		// Méthodes de l'interface IPlayer à redéfinir
	public void command() {
		
	}

	public String getName() {
		return name;
	}

	public int getLife() {
		return life;
	}

	public int getSpeed() {
		return speed;
	}
	
	public int getBombBag() {
		return bombBag;
	}
	
	public int getBombSize() {
		return bombSize;
	}

	public void setBombSize(int bombSize) {
		this.bombSize = bombSize;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setBombBag(int bombBag) {
		this.bombBag = bombBag;
	}

}
