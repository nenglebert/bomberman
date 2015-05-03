
	// Le block disparaît de la map et doit laisser place à un bonus
public class BlockExplosion implements IExplosion {

	public void explose(int posx, int posy, Board board, Player player) {
		Double proba = 0.6;
		if(Math.random() >= proba){
			//Une chance sur 3 d'avoir un bonus
			Double wbonus = Math.random();
			
			//Bombe
			if(0 < wbonus && 0.2 > wbonus)
				board.setElemInBoard(posx, posy, new Bonus(posx,posy, 1, "bonus1.png"));
			
			//Vie (On peut changer l'image si on veut)
			if(0.2 < wbonus && 0.4 > wbonus)
				board.setElemInBoard(posx, posy, new Bonus(posx,posy, 2, "bonus2.png"));
			
			//Taille bombe
			if(0.4 < wbonus && 0.6 > wbonus)
				board.setElemInBoard(posx, posy, new Bonus(posx,posy, 3, "bonus3.png"));
			
			//Bombe atomique 
			if(0.6 < wbonus && 0.8 > wbonus)
				board.setElemInBoard(posx, posy, new Bonus(posx, posy, 4, "bonus4.jpeg"));
			
			//Teleportation
			if(0.8 < wbonus)
				board.setElemInBoard(posx, posy, new Bonus(posx, posy, 5, "zaap1.png"));
		}
	}
}
