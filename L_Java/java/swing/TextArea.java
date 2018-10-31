package swing;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 文本域
 * @author PP
 * time 2017/07/09
 *
 */
public class TextArea extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JButton b = new JButton("Add Date");
	private JButton c = new JButton("Clear Date");			
	private JTextArea t = new JTextArea(20, 40);
	private Map<String, String> m = new HashMap<String, String>();
	
	public TextArea() {
		m.put("1", "a");
		m.put("2", "b");
		m.put("3", "c");
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(Map.Entry<String,String> me : m.entrySet()) {
					t.append(me.getKey() + ": " + me.getValue());
				}
			}
		});
		
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t.setText("");
			}
		});
		setLayout(new FlowLayout());
		add(new JScrollPane(t));
		add(b);
		add(c);
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new TextArea(), 475, 425);
	}
	
}
