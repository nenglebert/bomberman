import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class StartActionListener implements ActionListener {
	
	private GamePanel panel;
	private JPanel subPanel;
	
	public StartActionListener(GamePanel panel, JPanel subPanel) {
		this.panel = panel;
		this.subPanel = subPanel;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		panel.playerChooseWindow(subPanel);
	}
		
}
