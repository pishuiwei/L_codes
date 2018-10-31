package swing;

import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.JFrame;

/**
 * 创建按钮
 * @author PP
 * time 2017/07/09
 */
public class Button1 extends JFrame{
	private static final long serialVersionUID = 1L;
	private Button b1 = new Button("Button1");
	private Button b2 = new Button("Button2");
	
	public Button1() {
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new Button1(),200,100);
	}


}
