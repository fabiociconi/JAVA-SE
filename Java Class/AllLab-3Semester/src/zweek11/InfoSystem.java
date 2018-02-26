package zweek11;

import javax.swing.JFrame;


public class InfoSystem extends JFrame {

	public InfoSystem() throws Exception {

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
		InfoSystem frame = new InfoSystem();
		frame.setSize(400, 600);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
