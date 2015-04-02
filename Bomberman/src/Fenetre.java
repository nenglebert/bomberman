import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Fenetre extends JFrame {
	
	public Panneau pan = new Panneau();


	//Constructeur de la simple fenêtre
	public Fenetre(){		
		this.setTitle("Animation");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//"Charge" le contenu JPanel sur la page
		this.setContentPane(new Panneau());
		this.setVisible(true);
		
		 this.addKeyListener(new KeyAdapter() {
		        public void keyPressed(KeyEvent e) {
		            if ((e.getKeyCode()==KeyEvent.VK_SPACE)) {
		            	 int x = pan.getPosX();
		            	// System.out.println(x);
		            	pan.setPosX(x-10);
		                System.out.println("Putain de touche SPACE !");
		                
		            }
		        }
		    }
		    );
		 int x2 = pan.getPosX();
		 System.out.println(x2);
		go();
	}
	
	
	
	private void go(){  
		while(true){
			//On redessine notre Panneau
		      pan.repaint();
		      try {
		        Thread.sleep(3);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		}
	}
}

  
