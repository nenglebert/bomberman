
public class Fire extends Element{
	
		// Nos flammes
	public Fire(String skin, int posx, int posy){
		this.skin = skin;
		this.explosion = new DeleteExplosion();
		this.posx = posx;
		this.posy = posy;
	}
}

