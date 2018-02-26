package week7;

import java.awt.FlowLayout;

import javax.swing.*;

public class FlowLayoutTest extends JFrame{
	
	public FlowLayoutTest(String title){
    	super(title);
		JButton btn = new JButton("Test");
		add(btn); 
		JButton btn2 = new JButton("Test2");
		add(btn2);
		add(new JButton("Test3"));
		add(new JLabel("This is a label"));
		
		setLayout(new  FlowLayout()); 

	}
	public static void main(String s[]) {
		FlowLayoutTest mf = new FlowLayoutTest("Flowlayout window");
		mf.setSize(300,300);
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
