import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


	//Gère les blocs se détruisant lors d'une explosion
public class Block extends Element{
	
	public Block(int posx, int posy, Image skin) throws IOException{
		this.skin = skin;
		this.explosion = new BlockExplosion();
		this.posx = posx;
		this.posy = posy;
	}
}
