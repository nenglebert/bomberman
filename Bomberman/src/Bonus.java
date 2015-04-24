
	// Pour les bonus
public class Bonus extends Element {
	
	public String type;
	
	public Bonus(int posx, int posy, String type, String skin){
		this.skin = skin;
		this.type = type ;
		this.explosion = new DeleteExplosion();
		this.posx = posx;
		this.posy = posy;
	}
	
	public String getType(){
		return type;
	}
}
