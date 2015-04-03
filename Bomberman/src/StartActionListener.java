import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class StartActionListener implements ActionListener {
	
	GUI frame;
	JPanel subPanel;
	
	public StartActionListener(GUI frame, JPanel subPanel) {
		this.frame = frame;
		this.subPanel = subPanel;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		frame.playerChooseWindow(subPanel);
	}
		
}
