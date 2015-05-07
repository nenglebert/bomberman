import java.awt.Image;


	//Gère les blocs se détruisant lors d'une explosion
public class Block extends Element{
	
	public Block(int posx, int posy, Image skin){
		this.skin = skin;
		this.explosion = new BlockExplosion();
		this.posx = posx;
		this.posy = posy;
	}
}
