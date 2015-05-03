
public class NonExplosion implements IExplosion{
	
	public void explose(int posx, int posy, Board board, Player player) {
		Double proba = 0.6;
		if(Math.random() >= proba){
			//Une chance sur 3 d'avoir un bonus
			Double wbonus = Math.random();
			
			//Bombe
			if(0 < wbonus && 0.33 > wbonus)
				board.setElemInBoard(posx, posy, new Bonus(posx,posy, 1, "bonus1.png"));
			
			//Vie (On peut changer l'image si on veut)
			if(0.33 < wbonus && 0.66 > wbonus)
				board.setElemInBoard(posx, posy, new Bonus(posx,posy, 2, "bonus2.png"));
			
			//Speed 
			if(wbonus > 0.66)
				board.setElemInBoard(posx, posy, new Bonus(posx,posy, 3, "bonus3.png"));
			
			
			
		}
	}
	
}
