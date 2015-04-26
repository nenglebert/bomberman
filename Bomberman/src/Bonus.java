
	// Pour les bonus
public class Bonus extends Element {
	
	public int type;
	
	public Bonus(int posx, int posy, int type, String skin){
		this.skin = skin;
		this.type = type ;
		this.explosion = new DeleteExplosion();
		this.posx = posx;
		this.posy = posy;
	}
	
	public int getType(){
		return type;
	}
}
