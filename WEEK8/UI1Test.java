import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;

public class UI1Test extends JFrame {
	private String colors[] = {"Yellow", "Blue", "Red", "Green"};
	private Color colobj[]= {Color.yellow, Color.blue, Color.red, Color.green};

	public UI1Test(String title){
    	super(title);
		JButton btn = new JButton("Test Btn");
		add(btn); 
		
		JList list = new JList(colors);
		list.setVisibleRowCount(2);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(list));
		list.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent event) {
				btn.setBackground(colobj[list.getSelectedIndex()]);
			}
		});
		
		
		setLayout(new FlowLayout()); 		
	}
	public static void main(String args[]){
		UI1Test mf = new UI1Test("UI Test1");
		mf.setSize(300,300);
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
}
