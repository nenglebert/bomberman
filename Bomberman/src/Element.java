
abstract class Element {
	protected String skin;
	protected Explose explose;
	protected int posx;
	protected int posy;
	protected int life;
	
	public void loseLife(){
		
	}
	
	public String getSkin(){
		return skin;
	}
	
	public int getPosx(){
		return posx;
	}
	
	public int getPosy(){
		return posy;
	}
	
	public int getLife(){
		return life;
	}
	
	public void setPosx(int posx){
		this.posx = posx;
	}
	
	public void setPosy(int posy){
		this.posy = posy;
	}
	
	public void setLife(int life){
		this.life = life;
	}
}
