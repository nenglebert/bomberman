
	// Les blocks cassables
public class Block extends Element{
	
	public Block(int posx, int posy){
		this.skin = "block.png";
		this.explosion = new DeleteExplosion();
		this.posx = posx;
		this.posy = posy;
	}
}
