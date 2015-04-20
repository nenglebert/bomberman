
public class Block extends Element{
	
	public Block(int posx, int posy){
		this.skin = "block.png";
		this.explose = new PExplose();
		this.posx = posx;
		this.posy = posy;
		this.life = 1;
	}
}
