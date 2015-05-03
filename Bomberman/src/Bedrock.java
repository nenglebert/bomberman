
	//Les blocks qui ne pète pas
public class Bedrock extends Element{
	
	public Bedrock(int posx, int posy){
		this.skin = "HardBlock.png";
		this.explosion = new NonExplosion();
		this.posx = posx;
		this.posy = posy;
	}
}
