
public class Bedrock extends Element{
	
	public Bedrock(int posx, int posy){
		this.skin = "bedrock.png";
		this.explose = new NExplose();
		this.posx = posx;
		this.posy = posy;
		this.life = 1;
	}
}
