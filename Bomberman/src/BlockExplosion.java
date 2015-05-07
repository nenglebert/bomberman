import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


	// Le block disparaît de la map et doit laisser place à un bonus
public class BlockExplosion implements IExplosion {

	public void explose(int posx, int posy, Board board, Player player) throws IOException {
		Double proba = 0.6;
		Image bonus1 = ImageIO.read(new File("bonus1.png"));
		Image bonus2 = ImageIO.read(new File("bonus2.png"));
		Image bonus3 = ImageIO.read(new File("bonus3.png"));
		Image bonus4 = ImageIO.read(new File("bonus4.jpeg"));
		Image zaap1 = ImageIO.read(new File("zaap1.png"));
		if(Math.random() >= proba){
			//Une chance sur 3 d'avoir un bonus
			Double wbonus = Math.random();
			
			//Bombe
			if(0 < wbonus && 0.2 > wbonus)
				board.setElemInBoard(posx, posy, new Bonus(posx,posy, 1, bonus1));
			
			//Vie (On peut changer l'image si on veut)
			if(0.2 < wbonus && 0.4 > wbonus)
				board.setElemInBoard(posx, posy, new Bonus(posx,posy, 2, bonus2));
			
			//Taille bombe
			if(0.4 < wbonus && 0.6 > wbonus)
				board.setElemInBoard(posx, posy, new Bonus(posx,posy, 3, bonus3));
			
			//Bombe atomique 
			if(0.6 < wbonus && 0.8 > wbonus)
				board.setElemInBoard(posx, posy, new Bonus(posx, posy, 4, bonus4));
			
			//Teleportation
			if(0.8 < wbonus)
				board.setElemInBoard(posx, posy, new Bonus(posx, posy, 5, zaap1));
		}
	}
}
