import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Fenetre extends JFrame implements KeyListener{
	
	public Panneau pan = new Panneau();
	JTextField KeyCodeT = new JTextField("Key Code:");


	//Constructeur de la simple fenÃªtre
	public Fenetre(){		
		this.addKeyListener(this);
		
		this.setTitle("Animation");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		
		//"Charge" le contenu JPanel sur la page
		this.setContentPane(pan);
		this.setVisible(true);
		
		//Recharge la page
		go();
	}
	
	/////////////////
	//Lorsqu'une touche est appuyée
	public void keyPressed(KeyEvent e){
		 int x = pan.getPosX();
		 pan.setPosX(x+10);
		 pan.repaint();
		 if(e.getKeyCode()==KeyEvent.VK_SPACE)
			 System.out.println("ESPAAAAACE ! <3");
	}
	
	//Touche lachée
	public void keyReleased(KeyEvent e){
	}
	
	public void keyTyped(KeyEvent e){
	
	
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

  
