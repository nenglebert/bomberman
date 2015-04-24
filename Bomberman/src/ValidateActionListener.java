import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

public class ValidateActionListener implements ActionListener{
	
	GamePanel panel;
	int playerNumber;
	ArrayList<JTextField> nameFields;
	
	public ValidateActionListener(GamePanel panel, ArrayList<JTextField> nameFields, int playerNumber){
		this.panel = panel;
		this.playerNumber = playerNumber;
		this.nameFields = nameFields;
	}
	
	public void actionPerformed(ActionEvent e){
		panel.resetName();
		for (int i=0; i<playerNumber; i++){
			panel.setName(nameFields.get(i).getText());
		}
		
		//Va créer les joueurs en question
		panel.createPlayers(playerNumber);
	}
}
