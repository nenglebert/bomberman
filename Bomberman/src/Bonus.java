import java.awt.Image;


	//Gère les bonus
public class Bonus extends Element {
	
	private int type;
	
	public Bonus(int posx, int posy, int type, Image skin){
		this.skin = skin;
		this.type = type ;
		this.posx = posx;
		this.posy = posy;
	}
	
	public int getType(){
		return type;
	}
}
