
	// Simplement disparaître de la board sans action supplémentaire
public class DeleteExplosion implements IExplosion {

	public void explose(int posx, int posy, Board board) {
		board.setElemInBoard(posx, posy, null);
	}

}
