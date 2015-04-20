
public class Bomb extends Element {
	
	public Bomb(int posx, int posy){
		this.skin = "bomb.png";
		this.explose = new PExplose();
		this.posx = posx;
		this.posy = posy;
		this.life = 1;
	}
}
