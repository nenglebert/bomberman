import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PlayerActionListener implements ActionListener {
	
	GUI frame;
	JPanel subPanel;
	int playerNumber;
	
	public PlayerActionListener(GUI frame, JPanel subPanel, int playerNumber){
		this.frame = frame;
		this.subPanel = subPanel;
		this.playerNumber = playerNumber;
	}

	public void actionPerformed(ActionEvent arg0){
		frame.takePlayersName(subPanel, playerNumber);
	}
	
}
