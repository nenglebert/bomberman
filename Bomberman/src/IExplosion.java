import java.io.IOException;


// Interface servant à ce que la méthode explosion produise une action 
// différente en fonction de la classe sur laquelle elle est appliquée

public interface IExplosion{
	
	public void explose(int posx, int posy, Board board, Player player) throws IOException;
}
