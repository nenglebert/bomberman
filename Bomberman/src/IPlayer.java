
	// Interface qui regroupe les méthodes propres à Player
public interface IPlayer {
	public void command();
	
	public String getName();
	public int getLife();
	public int getSpeed();
	public int getBombBag();
	
	public void setName(String name);
	public void setLife(int life);
	public void setSpeed(int speed);
	public void setBombBag(int bombBag);
}

