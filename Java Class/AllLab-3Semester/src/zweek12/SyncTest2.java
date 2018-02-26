package zweek12;


import java.awt.*;
import javax.swing.*;

public class SyncTest2 extends JFrame
{
	private JTextField tf, tf2;
	SyncTest2()
	{
		setSize(200, 200);
		tf = new JTextField();
		tf2 = new JTextField();
		add(tf, "North");
		add(tf2, "South");
	}
	public static void main(String s[])
	{
		SyncTest2 st = new SyncTest2();
		st.setVisible(true);
		Counter2 c = new Counter2(st.tf, st.tf2);
		c.start();
		CheckCount2 cc = new CheckCount2(c);
		cc.start();
	}
}

class Counter2 extends Thread
{
	int count = 0, count2 = 0;
	JTextField tf, tf2;

	Counter2 (JTextField tf, JTextField tf2)
	{	this.tf = tf;	this.tf2 = tf2;}
        @Override
	public void run()
	{	while(true)
		{	try { sleep(100); } catch(InterruptedException ie){}
			increment();
		}
	}
	synchronized void increment()
	{
			count++;   
			tf.setText(""+count);
			count2++;
			tf2.setText(""+count2);
	}
	synchronized public boolean checkCount()
	{ return (count == count2);	}
}

class CheckCount2 extends Thread
{	
	Counter2 c;
	CheckCount2(Counter2 c)
	{	this.c = c;	 }
        @Override
	public void run()
	{
		while(true)
		{	try { sleep(50); } catch(InterruptedException ie){}
			if (c.checkCount() == true)
				System.out.println("Equals");
			else
			{
				System.out.println("*** NOT Equal");
				//break;
			}
		}
	}
}