import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ValidateActionListener implements ActionListener{
	
	GUI frame;
	int playerNumber;
	JTextField name1Field;
	JTextField name2Field;
	JTextField name3Field;
	JTextField name4Field;
	String name1;
	String name2;
	String name3;
	String name4;
	
	public ValidateActionListener(GUI frame, JTextField name1Field, JTextField name2Field, JTextField name3Field, JTextField name4Field, int playerNumber){
		this.frame = frame;
		this.playerNumber = playerNumber;
		this.name1Field = name1Field;
		this.name2Field = name2Field;
		this.name3Field = name3Field;
		this.name4Field = name4Field;
	}
	
	public void actionPerformed(ActionEvent e){
		if (playerNumber == 2){
			name1 = name1Field.getText();
			name2 = name2Field.getText();
			frame.setName1(name1);
			frame.setName2(name2);
		}
		
		else if (playerNumber == 3){
			name1 = name1Field.getText();
			name2 = name2Field.getText();
			name3 = name3Field.getText();
			frame.setName1(name1);
			frame.setName2(name2);
			frame.setName3(name3);
		}

		else if (playerNumber == 4){
			name1 = name1Field.getText();
			name2 = name2Field.getText();
			name3 = name3Field.getText();
			name4 = name4Field.getText();
			frame.setName1(name1);
			frame.setName2(name2);
			frame.setName3(name3);
			frame.setName4(name4);
		}
		
		//Ca c'est pour tester si ça fonctionne
		System.out.println(frame.getName1());
		System.out.println(frame.getName2());
		frame.setVisible(false);
	}
}
