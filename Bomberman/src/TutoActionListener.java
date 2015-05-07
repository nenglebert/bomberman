import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;


public class TutoActionListener implements ActionListener {
	GameWindow gameWindow;
	TutoPanel tutoPanel = new TutoPanel();
	
	public TutoActionListener(GameWindow gameWindow){
		this.gameWindow = gameWindow;
		tutoPanel.setPreferredSize(new Dimension(1890,1080));
	}

	public void actionPerformed(ActionEvent e) {
		gameWindow.setContentPane(tutoPanel);
		gameWindow.repaint();
		gameWindow.pack();
	}
}
