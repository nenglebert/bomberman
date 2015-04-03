import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.*;

public class GUI extends JFrame {
	
	private ImagePanel imagePanel;		//Le panel global avec image
	private JPanel subPanel;			//Le panel qui va contenir les boutons
	
	private JButton startButton;		//Bouton "Start"
	private JButton tutoButton;			//Bouton "Tutorial"
	private JButton homeButton;			//Bouton "Menu Principal"
	private JButton player2Button;		//Bouton "2 players"
	private JButton player3Button;		//Bouton "3 players"
	private JButton player4Button;		//Bouton "4 players"
	private JButton validateButton;		//Bouton "Validate"
	
	private JLabel introLabel;			//Texte "Be strong and play !"			
	private JLabel playerLabel;			//Texte "Choose the number of player"
	private JLabel nameLabel;			//Texte "Enter the players name"
	
	private JTextField name1Field;		//Zone pour le premier nom
	private JTextField name3Field;		//et ainsi de suite
	private JTextField name4Field;		
	private JTextField name2Field;		
	
	private String player1;				//Nom du joueur1
	private String player2;				//et ainsi de suite
	private String player3;
	private String player4;
	 
	
	public GUI(){
		this.initialize();
	}

	public void initialize() {
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setResizable(false);
		
		//Création de nos objets
		imagePanel = new ImagePanel();
		subPanel = new JPanel();
		
		startButton = new JButton("Start game");
		tutoButton = new JButton("Tutorial");
		homeButton = new JButton("Home");
		player2Button = new JButton("2 Players");
		player3Button = new JButton("3 Players");
		player4Button = new JButton("4 Players");
		validateButton = new JButton("Validate");
		
		introLabel = new JLabel("Take up the challenge and play !");
		playerLabel = new JLabel("Choose the number of player");
		nameLabel = new JLabel("     Enter the players name");
		
		name1Field = new JTextField("Name player1");
		name2Field = new JTextField("Name player2");
		name3Field = new JTextField("Name player3");
		name4Field = new JTextField("Name player4");
		
		//Pour effacer le texte dans le champ
		name1Field.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e){
				name1Field.setText("");
			}
		});
		
		name2Field.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e){
				name2Field.setText("");
			}
		});
		
		name3Field.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e){
				name3Field.setText("");
			}
		});
		
		name4Field.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e){
				name4Field.setText("");
			}
		});
		
		//On sectionne le panel pour avoir 3 lignes et 1 colonne
		subPanel.setLayout(new GridLayout(3,1));
		
		//Pour que la souris devient une main (c'est joliii !)
		startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tutoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		player2Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		player3Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		player4Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		validateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		homeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//On prépare le premier affichage
		subPanel.add(introLabel);
		subPanel.add(startButton);
		subPanel.add(tutoButton);
		subPanel.setOpaque(false);		//C'est pour ne pas avoir de bouton dégueu
		imagePanel.add(subPanel);		//On met tout sur notre panel générale
		
		imagePanel.setPreferredSize(new Dimension(600, 600));
		getContentPane().add(imagePanel);	//Pour l'ajouter sur la fenêtre
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);		//Apparaît au milieu de l'écran
		
		//Définissions des boutons
		startButton.addActionListener(new StartActionListener(this,subPanel));
		homeButton.addActionListener(new HomeActionListener(this,subPanel));
		player2Button.addActionListener(new PlayerActionListener(this,subPanel,2));
		player3Button.addActionListener(new PlayerActionListener(this,subPanel,3));
		player4Button.addActionListener(new PlayerActionListener(this,subPanel,4));
	}
	
	public void returnHome(JPanel subPanel){
		//Retour au menu principal
		subPanel.removeAll();
		subPanel.setLayout(new GridLayout(3,1));
		subPanel.add(introLabel);
		subPanel.add(startButton);
		subPanel.add(tutoButton);
		subPanel.revalidate();
	}
	
	public void playerChooseWindow(JPanel subPanel){
		//Fait apparaître la page 2 (choix du nombre de joueur)
		subPanel.removeAll();
		subPanel.setLayout(new GridLayout(5,1));
		
		subPanel.add(playerLabel);
		subPanel.add(player2Button);
		subPanel.add(player3Button);
		subPanel.add(player4Button);
		subPanel.add(homeButton);
	
		subPanel.revalidate();
	}
	
	public void takePlayersName(JPanel subPanel, int playerNumber){
		//Récupère le nom des joueurs
		subPanel.removeAll();
		subPanel.setLayout(new GridLayout(2*playerNumber + 2,1));
		
		subPanel.add(nameLabel);
		
		if (playerNumber == 2){
		subPanel.add(name1Field);
		subPanel.add(name2Field);
		}
		
		else if (playerNumber == 3){
			subPanel.add(name1Field);
			subPanel.add(name2Field);
			subPanel.add(name3Field);
		}
		
		else if (playerNumber == 4){
			subPanel.add(name1Field);
			subPanel.add(name2Field);
			subPanel.add(name3Field);
			subPanel.add(name4Field);
		}
		JPanel subSubPanel = new JPanel();
		subSubPanel.setLayout(new GridLayout(1,2));
		subSubPanel.add(validateButton);
		subSubPanel.add(homeButton);
		subSubPanel.setOpaque(false);
		
		validateButton.addActionListener(new ValidateActionListener(this,name1Field,name2Field,name3Field,name4Field,playerNumber));
		
		subPanel.add(subSubPanel);
		subPanel.revalidate();
	}
	
	//Les getteurs
	public String getName1(){
		return player1;
	}
	
	public String getName2(){
		return player2;
	}
	
	public String getName3(){
		return player3;
	}
	
	public String getName4(){
		return player4;
	}
	
	
	//Les setteurs
	public void setName1(String name){
		player1 = name;
	}
	
	public void setName2(String name){
		player2 = name;
	}
	
	public void setName3(String name){
		player3 = name;
	}
	
	public void setName4(String name){
		player4 = name;
	}
	
}
