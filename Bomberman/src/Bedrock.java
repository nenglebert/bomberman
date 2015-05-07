import java.awt.Image;
import java.io.IOException;


	//Gère les blocs ne se détruisant pas lors d'une explosion
public class Bedrock extends Element{
	
	public Bedrock(int posx, int posy, Image skin) throws IOException{
		this.skin = skin;
		this.explosion = new NonExplosion();
		this.posx = posx;
		this.posy = posy;
	}
}
