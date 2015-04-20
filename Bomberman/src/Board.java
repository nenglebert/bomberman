import java.util.ArrayList;


public class Board {
	
	 Element[][] table = new Element[15][15];
	 Player[] listPlayer = new Player[5];
	
	// Constructeur par défaut
	public Board(){
		
	}
	
	// Faire constructeur adapté au nombre
	// de joueurs
	
	
	// Accesseurs
	public Element[][] getTable(){
		return table;
	}
	
	// Mutateurs
	public void setTable(Element[][] pTable){
		this.table = pTable;
	}
	
	
	// Raffraichissement 
	public void go(){
		System.out.println("C'est parti les lardons !");
	}
}
