import java.util.Timer;
import java.util.TimerTask;

	// Défini la méthode explose() pour les élements de type "Block".
	// Elle cause la suppression du bloc et laisse apparaître un bonus
	// à la place de celui-ci.
public class BlockExplosion implements IExplosion {
	private Timer timer = new Timer();
	public void explose(final int posx, final int posy, final Board board, Player player){
		final Double proba = 0.6;
		timer.schedule(new TimerTask(){
			public void run(){
				if(Math.random() >= proba){
					//Une chance sur 3 d'avoir un bonus
					Double wbonus = Math.random();
					
					//Bombe
					if(0 < wbonus && 0.2 > wbonus)
						board.setElemInBoard(posx, posy, new Bonus(posx,posy, 1, board.getBonusSkin(0)));
					
					//Vie (On peut changer l'image si on veut)
					if(0.2 < wbonus && 0.4 > wbonus)
						board.setElemInBoard(posx, posy, new Bonus(posx,posy, 2, board.getBonusSkin(1)));
					
					//Taille bombe
					if(0.4 < wbonus && 0.6 > wbonus)
						board.setElemInBoard(posx, posy, new Bonus(posx,posy, 3, board.getBonusSkin(2)));
					
					//Bombe atomique 
					if(0.6 < wbonus && 0.7 > wbonus)
						board.setElemInBoard(posx, posy, new Bonus(posx, posy, 4, board.getBonusSkin(3)));
					
					//Teleportation
					if(0.7 < wbonus)
						board.setElemInBoard(posx, posy, new Bonus(posx, posy, 5, board.getBonusSkin(4)));
			
				}
			}}, 1000);
				
	}
}
