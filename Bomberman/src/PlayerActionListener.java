import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PlayerActionListener implements ActionListener {
	
	private GamePanel panel;
	private JPanel subPanel;
	private int playerNumber;
	
	public PlayerActionListener(GamePanel panel, JPanel subPanel, int playerNumber){
		this.panel = panel;
		this.subPanel = subPanel;
		this.playerNumber = playerNumber;
	}

	public void actionPerformed(ActionEvent arg0){
		panel.takePlayersName(subPanel, playerNumber);
	}
	
}
