import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


	//Les blocks qui ne pète pas
public class Bedrock extends Element{
	
	public Bedrock(int posx, int posy, Image skin) throws IOException{
		this.skin = skin;
		this.explosion = new NonExplosion();
		this.posx = posx;
		this.posy = posy;
	}
}
