package newpackage;

import javax.swing.JOptionPane;


public class Driver 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	



		int    accountnumber = Integer.parseInt(JOptionPane.showInputDialog("Insert Account:"));		
		String firstName     = JOptionPane.showInputDialog("First Name:"); 		 
		int balance          = Integer.parseInt(JOptionPane.showInputDialog("Insert Account:")); 	

		BankAccount BankAccount1 = new BankAccount(accountnumber, firstName, balance);
		//saque saque1 = new saque(x);

		String msg = BankAccount1.getAccountInfo();

		JOptionPane.showMessageDialog(null, msg);

	}
}
