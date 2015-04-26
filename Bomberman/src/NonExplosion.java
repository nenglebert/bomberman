
public class NonExplosion implements IExplosion{
	
	public void explose(int posx, int posy, Board board) {
		Double proba = 0.6;
		if(Math.random() >= proba){
			board.setElemInBoard(posx, posy, new Bonus(posx,posy, "bomb", "bonus.png"));
		}
	}
	
}
