import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Fenetre extends JFrame {
	
	//Constructeur de la simple fenêtre
	public Fenetre(){
		this.setTitle("Animation");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//"Charge" le contenu JPanel sur la page
		this.setContentPane(new Panneau());
		
		this.setVisible(true);
	}
  }  

  
