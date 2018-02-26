package week7;

/**
 * Simple AWT-abstract window toolkit- example
 */
import java.awt.FlowLayout;
import java.awt.*;

public class UITest extends Frame {
    public UITest(String title) {
    	super(title);
		Button btn = new Button("Test");
		btn.setBounds(10, 10, 20, 20);
		add(btn); 
		setLayout(new  FlowLayout()); 
	}

	public static void main(String s[]) {
		UITest mf = new UITest("Test window");
		mf.setSize(300,300);
		mf.setVisible(true);
	}
}
