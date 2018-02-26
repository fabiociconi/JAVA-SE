/*******************************************************************************
 * Lab - Client provide Account, Name and whether make a deposit or a          * 
 * withdrawal.Program return Account info formatted with new ballance          *
 *-----------------------------------------------------------------------------*
 * Date = 01/23/2017     +   LAB #1 - ex 2           + @author: Fabio Ciconi   *
 ******************************************************************************/

package exercise2;


public class BankAccount
{
    private int    account_number_bank;//Client Account Number
    private String first_Name_bank; //Client Name
    private double balance_bank;//Client balance
    private double value_bank;// Client Value digited
    private double value_bank_deposit; //Client value to deposit
    private double value_bank_withdrawal; //Client value to withdrawal
    private double balance_before;//Client Balance Before operation

    //Constructor 
   BankAccount(int aux_account, String aux_name,double aux_values, double aux_balance)
   {
      account_number_bank = aux_account;
      first_Name_bank     = aux_name;
      balance_bank        = aux_balance;
      value_bank          = aux_values;
   }

    //Calculate deposit
    //* @param aux_values - Value digited
    //* @param balance_bank - New balance 
   public void Deposit(double aux_values)
   {
      balance_before     = balance_bank;
      value_bank_deposit = aux_values;
      balance_bank       = balance_bank + aux_values;        
        
   }
    
    //Calculate Withdraw
    //* @param aux_values - Value digited
    //* @param balance_bank - New balance 
   public void get_Withdraw(double aux_values)
   {
      balance_before     = balance_bank;
      value_bank_deposit = aux_values;
      balance_bank       = balance_bank - aux_values;
       
   }

   //Take the actual Balance's client
   public String getBalance()
   {
   	String balancoinfo = String.format("Your Ammount is $: %.2f%n ", 
                                            balance_bank);      
      return balancoinfo;
   }
    
    //Format the information 
   public String getAccountInfo()
   {
    	String Info = String.format("  Cliente information : %n"
                + "Account Nnumber: %d%n"
                + "Name: %s%n"
                + "Balance Before      $: %.2f%n"
                + " + Value Deposit    $: %.2f%n"
                + " - Value Withdrawal $: %.2f%n"                                   
                + " = New Balance      $: %.2f%n",
                account_number_bank, first_Name_bank,balance_before,
                value_bank_deposit,value_bank_withdrawal,balance_bank);
    	
    	return Info;
   }
}
