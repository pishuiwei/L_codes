package swing;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SubmitSwingProgram extends JFrame {
	private static final long serialVersionUID = 1L;
	static SubmitSwingProgram ssp;
	JLabel jLabel;
	public SubmitSwingProgram() {
		super("Hell Swing");
		jLabel = new JLabel("A Lable");
		add(jLabel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) throws InterruptedException {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ssp = new SubmitSwingProgram();
			}
		});
		
		TimeUnit.SECONDS.sleep(1);
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ssp.jLabel.setText("Hey!This is different!");
			}
		});
		
	}
}



