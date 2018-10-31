package swing;

import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.JFrame;

/**
 * FlowLayout
 * 	从左到右"流动到窗体",直到站满窗体,然后下移动一行
 * @author PP
 * time 2017/07/10
 */
public class FlowLayout1 extends JFrame{
	private static final long serialVersionUID = 1L;

	public FlowLayout1() {
		setLayout(new FlowLayout());
		for(int i = 0; i<=20; i++) {
			add(new Button("Button" + i));
		}
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new FlowLayout1(), 300, 300);
	}
}
