import java.awt.Image;


	//Gère les blocs ne se détruisant pas lors d'une explosion
public class Bedrock extends Element{
	
	public Bedrock(int posx, int posy, Image skin) {
		this.skin = skin;
		this.posx = posx;
		this.posy = posy;
	}
}
