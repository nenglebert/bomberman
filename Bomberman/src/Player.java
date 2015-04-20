
public class Player extends Element implements IPlayer{
	
	private String name;
	private int speed;
	private int bombBag;
	
	public Player(String name){
		this.name = name;
		this.speed = 1;
		this.bombBag = 1;
	}
	
	public void command() {
		
	}
	
	public int getBombBag() {
		return bombBag;
	}
	
	public void setBombBag(int bombBag) {
		this.bombBag = bombBag;
	}
}
