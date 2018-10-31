package swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * BorderLayout
 * 	默认布局管理器,默认值为CENTER
 * @author PP
 * time 2017/0710
 */
public class BorderLayoyt1 extends JFrame{
	private static final long serialVersionUID = 1L;

	public BorderLayoyt1() {
		add(BorderLayout.NORTH, new JButton("North"));//顶端
		add(BorderLayout.SOUTH, new JButton("SOUTH"));//底端
		add(BorderLayout.EAST, new JButton("EAST"));//右端
		add(BorderLayout.WEST, new JButton("WEST"));//左端
		add(BorderLayout.CENTER, new JButton("CENTER"));//从中央开始填充，直到与其他组件或边框相遇
		
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new BorderLayoyt1(), 300, 250);
	}
}
