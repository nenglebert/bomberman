import java.io.IOException;


// Interface qui regroupe les différentes explosions : PlayerExplosion et BombExplosion
public interface IExplosion{
	
	public void explose(int posx, int posy, Board board, Player player) throws IOException;
}
