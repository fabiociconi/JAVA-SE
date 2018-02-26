package week7;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.*;

public class EventHandlerTest extends JFrame {

   public EventHandlerTest(String title) {
      super(title);
      JButton btn = new JButton("Test Btn");
      add(btn);
     
      btn.addActionListener(new BtnClickHandler());
      
      setLayout(new FlowLayout());
   }

   public static void main(String s[]) {
      EventHandlerTest mf = new EventHandlerTest("Event handler window");
      mf.setSize(300, 300);
      mf.setVisible(true);
      mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

}

class BtnClickHandler implements ActionListener {

   @Override
   public void actionPerformed(ActionEvent event) {
      System.out.println("Button clicked " + event.getActionCommand());
      
   }
}
