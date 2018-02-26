
/*  Clock.java : Illustrates use of multithreading - Runnable interface
*/
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Clock - Class that displays digital clock.
 */
public class ClockRunnable extends JFrame {
	private int count = 0;
	private JButton close, start;
	private JTextField tf;
	private boolean flag = true;

	/**
	 * Clock() - creates UI for digital clock.
	 */
	public ClockRunnable() {
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
	public static void main(String s[]) {
		Clock mt = new Clock();
		mt.setVisible(true);
	}

	/**
	*/
	void startClock() {
		ClockThread ct = new ClockThread(tf);
		Thread t = new Thread(ct);
		t.start();
	}

	class MWinListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	class ButtonActionStart implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			startClock();
		}
	}

	class ButtonActionStop implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			System.exit(0);
		}
	}
}

class ClockThread2 implements Runnable {
	private JTextField tf;
	private int hr, min, sec, ms;
	private Click2 cal = new Click2();

	ClockThread2(JTextField tf) {
		this.tf = tf;
	}

	public void run() {
		while (true) {
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException ie) {
			}
			cal.setTimeInMillis(System.currentTimeMillis());
			tf.setText(cal.get(cal.HOUR) + ":" + cal.get(cal.MINUTE) + ":" + +cal.get(cal.SECOND) + ":"
					+ cal.get(cal.MILLISECOND));
		}
	}
}

class Click2 extends GregorianCalendar {
	public void setTimeInMillis(long l) {
		super.setTimeInMillis(l);
	}
}

