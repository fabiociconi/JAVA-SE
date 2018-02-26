package week8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class LayoutTest {
    public static void main(String args[]) {
    	MyUI f = new MyUI("Layout test");
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 300);
        f.setVisible(true);
    }
}


class MyUI extends JFrame{
	private String colors[] = {"Yellow", "Blue", "Red", "Green"};
	MyUI(String title){
		super(title);
		setLayout(new BorderLayout());
		
		add(createPanel2(), BorderLayout.NORTH);
		add(createPanel1(), BorderLayout.CENTER);
		add(createPanel3(), BorderLayout.SOUTH);		
	}
	
	private JPanel createPanel1(){
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.YELLOW);
		panel1.setLayout(new FlowLayout());	
		
		panel1.add(new JComboBox(colors));
		JTextArea tarea = new JTextArea("this is text area");
		JScrollPane sp = new JScrollPane(tarea);
		tarea.setRows(5);
		panel1.add(sp);
		panel1.add(new JButton("btn1"));
		
		return panel1;
	}
	private JPanel createPanel2(){
         JPanel panel2 = new JPanel();
		panel2.setBackground(Color.green);
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));		
		panel2.add(new JButton("btn1"));
		panel2.add(new JButton("btn2"));
		panel2.add(new JButton("btn3"));
		return panel2;
	}
	private JPanel createPanel3(){
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.cyan);
		panel3.setLayout(new GridLayout(2,2));
		panel3.add(new JTextField("name"));
		panel3.add(new JTextField("lastname"));
		panel3.add(new JTextField("address"));
		panel3.add(new JButton("ok"));
		return panel3;
	}
}
