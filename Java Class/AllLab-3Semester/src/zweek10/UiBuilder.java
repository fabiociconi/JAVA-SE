package zweek10;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

class UiBuilder extends JPanel implements ActionListener {
	private JButton btnQuery, btnUpdate, btnAdd;
	private JTextField tfName, tflName, tfId;
	private DataAccess da;

	UiBuilder(DataAccess da) {
		this.da = da;
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();

		setSize(400, 400);
		btnQuery = new JButton("Query");
		btnUpdate = new JButton("Update");
		btnAdd = new JButton("Add");
		tfName = new JTextField(20);
		tflName = new JTextField(20);
		tfId = new JTextField(5);

		panel.setLayout(new GridLayout(3,3));
		panel.add(new Label("First Name: "));
		panel.add(tfName);
		panel.add(new Label("Last Name: "));
		panel.add(tflName);
		panel.add(new Label("Id: "));
		panel.add(tfId);

		panel2.setLayout(new FlowLayout());
		panel2.add(btnQuery);
		panel2.add(btnUpdate);
		panel2.add(btnAdd);
		btnQuery.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnAdd.addActionListener(this);

		//this.setLayout(new BorderLayout());
		add(panel);
		add(panel2);

	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == btnQuery) {
			String id = tfId.getText();
			if (id != null) {
				try {
					Student st = da.findStudent(id);
					tfName.setText(st.getFirstName());
					tflName.setText(st.getLastName());
					tfId.setText(st.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else if (ev.getSource() == btnUpdate)// btnUpdate
		{
			try {
				Student st = new Student(tfName.getText(), tflName.getText(), tfId.getText());
				da.updateStudent(st);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {// add
			try {
				Student st = new Student(tfName.getText(), tflName.getText(), tfId.getText());
				da.addStudent(st);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}