package Exemplo2;

import javax.swing.JOptionPane;

/**
 *
 * @author ZeusAC
 */
public class Driver 
{

       public static void main(String[] args) 
    {	
    // TODO Auto-generated method stub

 	
    int AccountNumber   = Integer.parseInt(JOptionPane.showInputDialog("Insert Account:"));		
    String FirstName    = JOptionPane.showInputDialog("First Name:");   
    double Balance      = Integer.parseInt(JOptionPane.showInputDialog("Insert Balance:")); 
    char Depo_or_Wit = JOptionPane.showInputDialog("Please enter a D or W:").charAt(0);
    double Value = Integer.parseInt(JOptionPane.showInputDialog("Value:")); 
    
//   BankAccount BankAccount1 = new BankAccount(accountnumber, firstName, balance,deporwith,value);
     BankAccount BankAccount1 = new BankAccount(AccountNumber,FirstName,Depo_or_Wit,Value,Balance);
    
     
     if (Depo_or_Wit == 'W' || Depo_or_Wit == 'w')
     {
         BankAccount1.withdraw(Value);
    /*    if(Depo_or_Wit == 'D' || Depo_or_Wit == 'd') 
           { 
            BankAccount1.deposit(Value);*/
     } else {
            String message = String.format("Choose D or W");
            JOptionPane.showMessageDialog(null, message);

      }       
    
    String msg = BankAccount1.GetAccountInfo();
    JOptionPane.showMessageDialog(null, msg);
    }
}
