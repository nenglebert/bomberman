import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TutoActionListener implements ActionListener {
	private GamePanel gamePanel;
	
	public TutoActionListener(GamePanel gamePanel){
		this.gamePanel = gamePanel;
	}

	public void actionPerformed(ActionEvent e) {
		gamePanel.tutorial();
	}
}
