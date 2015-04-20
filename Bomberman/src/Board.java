import java.util.ArrayList;


public class Board {
	
	 ArrayList table = new ArrayList();
	 ArrayList listPlayer = new ArrayList();
	
	// Constructeur par défaut
	public Board(){
		
	}
	
	// Faire constructeur adapté au nombre
	// de joueurs
	
	
	// Accesseurs
	public ArrayList getTable(){
		return table;
	}
	
	// Mutateurs
	public void setTable(ArrayList pTable){
		this.table = pTable;
	}
	
	
	// Raffraichissement 
	public void go(){
		System.out.println("C'est parti les lardons !");
	}
}
