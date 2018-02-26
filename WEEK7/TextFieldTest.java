package week7;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TextFieldTest extends JFrame{
	   public TextFieldTest(String title) {
	    	super(title);
	    	JTextField tf = new JTextField("Enter text here");
	    	add(tf);
	    	tf.addActionListener(new TxtHandler());
			//JButton btn = new JButton("Test Btn");
			//add(btn); 
			//btn.addActionListener(new BtnClickHandler());
			setLayout(new FlowLayout()); 
		}

		public static void main(String s[]) {
			TextFieldTest mf = new TextFieldTest("Event handler window");
			mf.setSize(300,300);
			mf.setVisible(true);
			mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

}

class TxtHandler implements ActionListener{
	public void actionPerformed(ActionEvent event){
		System.out.println("Text is "+event.getActionCommand());
	}
}
