import javax.swing.JButton;
import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;

public class UITest extends JFrame {
	private String colors[] = {"Yellow", "Blue", "Red", "Green", "White", "Black"};
	private Color colobj[]= {Color.yellow, Color.blue, Color.red, Color.green, Color.white, Color.black};

	public UITest(String title){
    	super(title);
		JButton btn = new JButton("Test Btn");
		add(btn); 
		
		JComboBox list = new JComboBox(colors);
		list.setMaximumRowCount(2);
		add(new JScrollPane(list));
		list.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent event) {
				btn.setBackground(colobj[list.getSelectedIndex()]);
			}
		});
		
		
		setLayout(new FlowLayout()); 		
	}
	public static void main(String args[]){
		UITest mf = new UITest("UI Test");
		mf.setSize(300,300);
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
}
