import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuTest {
    public static void main(String args[]) {
    	MenuFrame mf = new MenuFrame("Menu test");
    	mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setSize(300,300);
     	mf.setVisible(true);
    }
}

class MenuFrame extends JFrame{
	MenuFrame(String title){
		super(title);

		JMenuBar mb = new JMenuBar();
		mb.add(createMenu1());
		mb.add(createMenu2());
		setJMenuBar(mb);
		pack();
		
	}
	private JMenu createMenu1(){
		JMenu filemenu = new JMenu("Menu1");
		filemenu.add(new JMenuItem("Open"));
		filemenu.add(new JMenuItem("Close"));
		filemenu.add(new JMenuItem("test"));
		filemenu.add(new JMenuItem("ok"));
		return filemenu;
	}
	private JMenu createMenu2(){
		JMenu menu2 = new JMenu("Menu2");
		menu2.add(new JMenuItem("option1"));
		menu2.add(new JMenuItem("option2"));
		menu2.add(new JMenuItem("option3"));
		return menu2;
	}
	
}
