import java.awt.Image;
import java.io.IOException;


	// Les blocks cassables
public class Block extends Element{
	
	public Block(int posx, int posy, Image skin) throws IOException{
		this.skin = skin;
		this.explosion = new BlockExplosion();
		this.posx = posx;
		this.posy = posy;
	}
}
