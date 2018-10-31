package swing;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class HelloSwing {
	public static void main(String[] args) throws InterruptedException {
		JFrame jFrame = new JFrame("Hello Swing");
		
		final JLabel jLabel = new JLabel("A Label");

		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(400, 300);
		jFrame.setVisible(true);
		jFrame.add(jLabel);
		
		//休眠一秒
		TimeUnit.SECONDS.sleep(1);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				jLabel.setText("Hey！This is different！");
			}
		});
	}
}
