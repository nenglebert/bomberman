import java.util.ArrayList;


public class Board {
	
	 Element[][] table = new Element[15][15];
	 Player[] listPlayer = new Player[5];
	
	// Constructeur par défaut
	public Board(){
		for (int i=1; i < table.length; i+=2){
			for (int j=1; j < table.length; j+=2){
				table[i][j] = new Bedrock(i,j);
			}
			
		}
		
		
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
