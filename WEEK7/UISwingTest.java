package week7;

import javax.swing.*;
import java.awt.FlowLayout;

public class UISwingTest extends JFrame{
	   public UISwingTest(String title) {
	    	super(title);
			JButton btn = new JButton("Test");
			btn.setBounds(10,10, 100,30);
			add(btn); 
			setLayout(null); 
        
        
		}

		public static void main(String s[]) {
			UISwingTest mf = new UISwingTest("Test window");
			mf.setSize(300,300);
			mf.setVisible(true);
			mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

}
