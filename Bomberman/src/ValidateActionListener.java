import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ValidateActionListener implements ActionListener{
	
	private GamePanel panel;
	private int playerNumber;
	private ArrayList<JTextField> nameFields;
	private JComboBox<String> boardSizeList;
	
	public ValidateActionListener(GamePanel panel, ArrayList<JTextField> nameFields, int playerNumber, JComboBox<String> boardSizeList){
		this.panel = panel;
		this.playerNumber = playerNumber;
		this.nameFields = nameFields;
		this.boardSizeList = boardSizeList;
	}
	
	public void actionPerformed(ActionEvent e){
		panel.resetName();
		for (int i=0; i<playerNumber; i++){
			panel.setName(nameFields.get(i).getText());
		}
		
		// Récupération de la taille du plateau et introduction dans le gamePanel
		String boardSize = (String) boardSizeList.getSelectedItem();
		if (boardSize == "11x11")
			panel.setBoardSize(10);
		
		else if (boardSize == "13x13")
			panel.setBoardSize(12);
		
		else if (boardSize == "15x15")
			panel.setBoardSize(14);
		
		else if (boardSize == "17x17")
			panel.setBoardSize(16);
		
		//Va créer les joueurs en question
		try {
			panel.createPlayers(playerNumber);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
