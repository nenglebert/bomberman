import java.util.ArrayList;


public class Board {
	
	 Element[][] table = new Element[15][15];
	 Player[] listPlayer = new Player[5];
	
	// Constructeur par défaut
	public Board(){
		//Placement des blocs incassables
		for (int i=1; i < table.length; i+=2){
			for (int j=1; j < table.length; j+=2){
				table[i][j] = new Bedrock(i,j);
			}
		}
		//Placement des blocs cassables
		for (int i=0; i < table.length; i++){
			for (int j=0; j < table.length; j++){
				
				//On augmente la probabilité si on est dans une ligne
				//ou des bedrocks sont présents
				double proba;
				if (i%2 != 1)
					proba = 0.4;
				else
					proba = 0.5;
				
				if(table[i][j] == null && Math.random() >= proba)
				table[i][j] = new Block(i,j);
			}
		}
		
		//Donne la place aux joueurs
		table[0][0]  = table[0][1]   = table[1][0]   = table[0][13]  = 
		table[0][14] = table[1][14]  = table[13][0]  = table[14][0]  = 
		table[14][1] = table[14][13] = table[14][14] = table[13][14] =
		null;
		
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
