import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.*;

public class AnonymousTest extends JFrame{
	   public AnonymousTest(String title) {
	    	super(title);
			JButton btn = new JButton("Test Btn");
			add(btn); 
			btn.addActionListener(new BtnClickHandler());
			btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					System.out.println("Button clicked reported from Anonymous class "+event.getActionCommand());
				}				
			});
			
			setLayout(new FlowLayout()); 
		}

		public static void main(String s[]) {
			AnonymousTest mf = new AnonymousTest("Event handler window");
			mf.setSize(300,300);
			mf.setVisible(true);
			mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

}

class BtnClickHandler implements ActionListener{
	public void actionPerformed(ActionEvent event){
		System.out.println("Button clicked "+event.getActionCommand());
	}
}

