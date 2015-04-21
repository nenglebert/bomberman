
public class EBomb implements Explose {
	
	public void explose(Panneau pan, int posx, int posy) {
		
		// Création de chaque objet flamme (par case, centrale, horizontale, verticale)
		Fire fireCenter = new Fire("explosionCentre.jpg",posx,posy);
		Fire fireH1 = new Fire("explosionHor.jpg",posx+1,posy);
		Fire fireH2 = new Fire("explosionHor.jpg",posx-1,posy);
		Fire fireV1 = new Fire("explosionVert.jpg",posx,posy+1);
		Fire fireV2 = new Fire("explosionVert.jpg",posx,posy-1);
		
		// Et la on fait apparaitre les flammes après conditions
		pan.board.table[posx][posy] = fireCenter;
		if (posx+1 <= 14 && !(pan.board.table[posx+1][posy] instanceof Bedrock)){
			pan.board.table[posx+1][posy] = fireH1;
		}
		if (0 <= posx-1 && !(pan.board.table[posx-1][posy] instanceof Bedrock)){
			pan.board.table[posx-1][posy] = fireH2;
		}
		if (posy+1 <= 14 && !(pan.board.table[posx][posy+1] instanceof Bedrock)){
			pan.board.table[posx][posy+1] = fireV1;
		}
		if (0 <= posy-1 && !(pan.board.table[posx][posy-1] instanceof Bedrock)){
			pan.board.table[posx][posy-1] = fireV2;
		}
	}

}
