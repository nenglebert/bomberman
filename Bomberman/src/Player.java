
	// Classe de l'élément joueur
public class Player extends Element implements IPlayer{

		// Attributs propres à Player
	private String name;
	private int life;
	private int speed;
	private int bombBag;
		
		// Constructeur de Player
	public Player(String skin, String name, int posx, int posy){
		this.skin = skin;
		this.explosion = new PlayerExplosion();
		this.posx = posx;
		this.posy = posy;
		this.name = name;
		this.life = 5;
		this.speed = 1;
		this.bombBag = 2;
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
