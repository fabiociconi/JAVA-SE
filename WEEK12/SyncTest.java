
import java.awt.*;
import javax.swing.*;

public class SyncTest extends JFrame {
	private JTextField tf, tf2;

	SyncTest() {
		setSize(200, 200);
		tf = new JTextField();
		tf2 = new JTextField();
		add(tf, "North");
		add(tf2, "South");
	}

	public static void main(String s[]) {
		SyncTest st = new SyncTest();
		st.setVisible(true);
		Counter c = new Counter(st.tf, st.tf2);
		c.start();
		CheckCount cc = new CheckCount(c);
		cc.start();
	}
}

class Counter extends Thread {
	private int count = 0, count2 = 0;
	private JTextField tf, tf2;

	Counter(JTextField tf, JTextField tf2) {
		this.tf = tf;
		this.tf2 = tf2;
	}

	public void run() {
		while (true) {
			try {
				sleep(100);
			} catch (InterruptedException ie) {
			}
			increment();
		}
	}

	void increment() {
		count++;
		tf.setText("" + count);
		count2++;
		tf2.setText("" + count2);
	}

	public boolean checkCount() {
		return (count == count2);
	}
}

class CheckCount extends Thread {
	private Counter c;

	CheckCount(Counter c) {
		this.c = c;
	}

	public void run() {
		while (true) {
			try {
				sleep(50);
			} catch (InterruptedException ie) {
			}
			if (c.checkCount() == true)
				System.out.println("Equals");
			else {
				System.out.println("*** NOT Equal");
				// break;
			}
		}
	}
}