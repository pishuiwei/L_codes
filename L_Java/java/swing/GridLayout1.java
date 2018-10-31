package swing;

import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * GridLayout
 * 	表格布局管理器
 * @author PP
 * time 2017/07/10
 */
public class GridLayout1 extends JFrame {
	private static final long serialVersionUID = 1L;

	public GridLayout1() {
		setLayout(new GridLayout(7, 3));
		for(int i = 0; i<20; i++) {
			add(new Button("Button" + i));
		}
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new GridLayout1(), 300, 300);
	}
}
