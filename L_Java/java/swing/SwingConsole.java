package swing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingConsole {
	public static void run(final JFrame f,final int width,final int height){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				f.setTitle(f.getClass().getSimpleName());
				f.setSize(width, height);
				f.setResizable(true);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setLocationRelativeTo(f.getOwner());// 屏幕居中
				f.setVisible(true);
			}
		});
	}
}
