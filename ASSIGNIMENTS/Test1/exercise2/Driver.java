/*******************************************************************************
 * Lab - Client provide Account, Name and whether make a deposit or a          * 
 * withdrawal.Program return Account info formatted with new ballance          *
 *-----------------------------------------------------------------------------*
 * Date = 01/23/2017     +   LAB #1 - ex 2           + @author: Fabio Ciconi   *
 ******************************************************************************/
package exercise2;

import javax.swing.JOptionPane;

public class Driver 
{

       public static void main(String[] args) 
    {	
        double value_dep_with = 0; //Value that client will deposit or  withdrawal    
        double balance = 5000.00; //Client balance
             
        int account_number = Integer.parseInt(JOptionPane.showInputDialog("Insert Account:"));//Client Account Number	
        
        String first_name  = JOptionPane.showInputDialog("First Name:");// Cliente First Name   
    
        
        BankAccount BankAccount1 = new BankAccount(account_number, 
                                       first_name,value_dep_with, balance);
    
        
        //Calling Balance
        String msg1 = BankAccount1.getBalance();
        
        //Show the Client Actual Balance
        JOptionPane.showMessageDialog(null,msg1);
    
        
        //Cliente will choose between Deposit or withdrawal
        char flag_depo_or_wit = JOptionPane.showInputDialog("Please enter a D or W:").charAt(0);// Option  D to deposit or W to withdrawal
        
        value_dep_with = Integer.parseInt(JOptionPane.showInputDialog("Value is:")); 
 
        if (flag_depo_or_wit == 'W' || flag_depo_or_wit == 'w')
        {
            //call withdrawal method
             BankAccount1.get_Withdraw(value_dep_with);
        }
        else 
            if(flag_depo_or_wit == 'D' || flag_depo_or_wit == 'd') 
           {
            //call deposit method   
            BankAccount1.Deposit(value_dep_with); 
            } 
            else 
                {
                  String message = String.format("Back and Choose D or W ");
                  JOptionPane.showMessageDialog(null, message);
                 
                }        
       //Calling BankAccount class object's method
    String msg = BankAccount1.getAccountInfo();
    //Show formatted result	
    JOptionPane.showMessageDialog(null, msg);
    }
}

