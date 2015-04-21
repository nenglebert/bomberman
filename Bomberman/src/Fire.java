
public class Fire extends Element{
	// Nos flammes
	public Fire(String skin, int posx, int posy){
	this.skin = skin;
	this.explose = new EBomb();
	this.posx = posx;
	this.posy = posy;
	this.life = 1;
	}
}
