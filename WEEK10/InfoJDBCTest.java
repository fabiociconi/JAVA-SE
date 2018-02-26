
import javax.swing.*;

public class InfoJDBCTest extends JFrame {

	public InfoJDBCTest() throws Exception {

		try {
			DataAccess da = new DataAccess();
			UiBuilder ui = new UiBuilder(da);
			this.add(ui);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public static void main(String s[]) throws Exception {
		InfoJDBCTest frame = new InfoJDBCTest();
		frame.setSize(300, 400);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

