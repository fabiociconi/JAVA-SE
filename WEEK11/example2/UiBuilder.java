package example2;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;

class UiBuilder extends JPanel implements ActionListener {
	private JButton btnQuery, btnUpdate, btnAdd;
	private JTextField tfName, tflName, tfId;
	private JList courseNames;
	private DataAccess da;

	UiBuilder(DataAccess da) {
		this.da = da;

		setSize(400, 400);

		JPanel studentPanel = createStudentPanel();
		JPanel buttonPanel = createButtonPanel();
		
		//this.setLayout(new BorderLayout());
		add(studentPanel);
		add(createCoursePanel());
		add(buttonPanel);
	}
	
	private JPanel createButtonPanel(){
		JPanel panel2 = new JPanel();
		btnQuery = new JButton("Query");
		btnUpdate = new JButton("Update");
		btnAdd = new JButton("Add");
		panel2.setLayout(new FlowLayout());
		panel2.add(btnQuery);
		panel2.add(btnUpdate);
		panel2.add(btnAdd);
		btnQuery.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnAdd.addActionListener(this);
		return panel2;
	}
	private JPanel createStudentPanel(){
		JPanel panel = new JPanel();
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
		return panel;
	}
	
	private JPanel createCoursePanel(){
		JPanel panel = new JPanel();
		courseNames = new JList(getCourseNames());
		courseNames.setVisibleRowCount(4);
		courseNames.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		panel.add(new Label("Courses: "));
		panel.add(new JScrollPane(courseNames));
		
		return panel;		
	}
	
	private String[] getCourseNames(){
		try {
			return da.getCourses();
		} catch(Exception ee){
			return new String[0];  //return an empty array
		}
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
					String courses[] = st.getCourses();
					int idxs[] = new int[courses.length];
					int i=0;
					for (String c: courses){
						courseNames.setSelectedValue(c, true);
						idxs[i]=courseNames.getSelectedIndex();
						i++;
					}
					courseNames.setSelectedIndices(idxs);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else if (ev.getSource() == btnUpdate)// btnUpdate
		{
			try {
				Student st = new Student(tfName.getText(), tflName.getText(), tfId.getText(), new String[0]);
				da.updateStudent(st);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {// add
			try {
				List<String> list = courseNames.getSelectedValuesList();
				String courses[] = new String[list.size()];
				Student st = new Student(tfName.getText(), tflName.getText(), tfId.getText(), 
							list.toArray(courses));
				da.addStudent(st);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}