package newpackage;

import javax.swing.JOptionPane;

public class LabTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int    id       = Integer.parseInt(JOptionPane.showInputDialog("Insert ID:"));		
		String fname    = JOptionPane.showInputDialog("First Name:"); 		 
		String lname    = JOptionPane.showInputDialog("Last Name:"); 	
		String address  = JOptionPane.showInputDialog("Address:"); 	
		String city     = JOptionPane.showInputDialog("City:"); 	
		String province = JOptionPane.showInputDialog("Province:"); 	
		String postal   = JOptionPane.showInputDialog("Postal Code:"); 	

		Patient patient1 = new Patient(id, fname, lname, address, city, province, postal);
		
		String msg = patient1.getPatientinfo();
		
		
		JOptionPane.showMessageDialog(null, msg);
	}

}
