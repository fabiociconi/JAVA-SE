/*******************************************************************************
 * Lab - Patient provide ID, First Name, Last Name, Address, City, Province,   *
 * and Postal Code -  Program return Patient info formatted                    *
 *-----------------------------------------------------------------------------*
 * Date = 01/23/2017     +   LAB #1 - ex 1           + @author: Fabio Ciconi   *
 ******************************************************************************/

package exercise1;

import javax.swing.JOptionPane;


public class LabTest 
{
   public static void main(String[] args) 
   {
      int    id       = Integer.parseInt(JOptionPane.showInputDialog("Insert ID:"));//Identification's Patient		
      String fname    = JOptionPane.showInputDialog("First Name:");//Patient First Name 		 
      String lname    = JOptionPane.showInputDialog("Last Name:");//Patient Last Name  	
      String address  = JOptionPane.showInputDialog("Address:"); //Patient Address 	
      String city     = JOptionPane.showInputDialog("City:"); //Patient City
      String province = JOptionPane.showInputDialog("Province:"); //Patient Province	
      String postal   = JOptionPane.showInputDialog("Postal Code:");//Patient Postal Code  	               
        
      //Only to demostrate a default constructor 
      Patient patient0 = new Patient();
        
      //Declare reference  - create object 
      Patient patient1 = new Patient(id, fname, lname, address, city, province, postal);
	
      //Calling Patient class object's method	
      String msg = patient1.getPatientinfo();
      //Show formatted result	
      JOptionPane.showMessageDialog(null, msg);
               
    }
}
