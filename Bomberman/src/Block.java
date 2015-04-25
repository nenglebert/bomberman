
	// Les blocks cassables
public class Block extends Element{
	
	public Block(int posx, int posy){
		this.skin = "block.png";
		this.explosion = new NonExplosion();
		this.posx = posx;
		this.posy = posy;
	}
}
