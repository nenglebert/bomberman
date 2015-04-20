public class Bonus extends Element {
	
	public String type;
	
	public Bonus(int posx, int posy, String type){
		//this.skin = ;
		this.type = type ;
		this.explose = new PExplose();
		this.posx = posx;
		this.posy = posy;
		this.life = 1;
	}
	
	public String getType(){
		return type;
	}
}
