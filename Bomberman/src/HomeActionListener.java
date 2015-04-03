import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class HomeActionListener implements ActionListener{
	GUI frame;
	JPanel subPanel;
	
	public HomeActionListener(GUI frame, JPanel subPanel){
		this.frame = frame;
		this.subPanel = subPanel;
	}
	
	public void actionPerformed(ActionEvent e){
		frame.returnHome(subPanel);
	}
}
