package zweek12;


/*  Clock.java : Illustrates use of multithreading
*/
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Clock - Class that displays digital clock.
 */
public class Clock extends JFrame 
{
    private final int count = 0;
    private JButton close, start;
    private JTextField tf;
    private boolean flag = true;

    /**
     * Clock() - creates UI for digital clock.
     */
    public Clock() 
    {
        setSize(200, 100);
        addWindowListener(new MWinListener());
        close = new JButton("Close");
        start = new JButton("Start");
	setLayout(new GridLayout(2,2));
	add(new JLabel("Time1"));
	tf = new JTextField(10);
	add(tf);
	add(close);
	add(start);
	close.addActionListener(new ButtonActionStop());
	start.addActionListener(new ButtonActionStart());
	addWindowListener(new MWinListener());
    }

    /**
     * main - entry point to digital clock program.
     * 
     * @param s[]
     *            - command line arguments. Not used.
     */
    public static void main(String s[]) 
    {
	Clock mt = new Clock();
	mt.setVisible(true);
    }

    /**
    */
    public void startClock() 
    {
	ClockThread ct = new ClockThread(tf);
	ct.start();
    }

    class MWinListener extends WindowAdapter 
    {
        @Override
	public void windowClosing(WindowEvent e) 
        {
            System.exit(0);
	}
    }

    class ButtonActionStart implements ActionListener 
    {
        @Override
	public void actionPerformed(ActionEvent ev) 
        {
            startClock();
	}
    }

    class ButtonActionStop implements ActionListener 
    {
        @Override
	public void actionPerformed(ActionEvent ev) 
        {
            System.exit(0);
	}
    }
}

class ClockThread extends Thread {
	private JTextField tf;
	private int hr, min, sec, ms;
	private Click cal = new Click();

	ClockThread(JTextField tf) 
        {
            this.tf = tf;
	}

        @Override
	public void run() 
        {
            while (true) 
            {
		try 
                {
                    Thread.currentThread().sleep(100);
		} catch (InterruptedException ie) 
                  {
                  }
		cal.setTimeInMillis(System.currentTimeMillis());
		tf.setText(cal.get(cal.HOUR) + ":" + cal.get(cal.MINUTE) 
                + ":" + +cal.get(cal.SECOND) + ":"
		+ cal.get(cal.MILLISECOND));
            }
	}
}

class Click extends GregorianCalendar {
        @Override
	public void setTimeInMillis(long l) {
		super.setTimeInMillis(l);
	}
}
