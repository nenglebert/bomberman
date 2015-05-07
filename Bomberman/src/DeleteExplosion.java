
    // Défini la méthode explose() pour les élements devant disparaître
	// du plateau de jeu comme pour les objets de type Bonus, Fire, ...
	// Après avoir supprimé l'élément, rien ne se passe.

public class DeleteExplosion implements IExplosion {

	public void explose(int posx, int posy, Board board, Player player) {
		board.setElemInBoard(posx, posy, null);
	}

}
