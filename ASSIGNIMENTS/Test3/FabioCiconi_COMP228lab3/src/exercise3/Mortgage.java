/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise3;

/**
 *
 * @author ZeusAC
 */
abstract public class Mortgage implements MortgageConstants 
{

   private int mortgageNumber;
   private String customerName;
   private double amountMortgage;
   double interestRate;
   private int term;
   private char mortgageType;

   /**
    *
    * @param mortgageType
    * @param mortgageNumber
    * @param customerName
    * @param amountMortgage
    * @param term
    */
   public Mortgage(char mortgageType, int mortgageNumber, String customerName, double amountMortgage, int term) 
   {
      this.mortgageNumber = mortgageNumber;
      this.customerName = customerName;
      this.term = term;
      this.mortgageType = mortgageType;
      if (amountMortgage > MAXMORTGAGEAMOUNT) 
      {
         this.amountMortgage = MAXMORTGAGEAMOUNT;
      } 
      else 
      {
         this.amountMortgage = amountMortgage;
      }
   }

   /**
    *
    * @return
    */
   public double getAmountOwed() 
   {
      return amountMortgage * (1 + interestRate);

   }

   /**
    *
    */
   public void getMortgageInfo() 
   {
      System.out.printf("Bank: %s\nMortgage Type: %c\nMortgage Number: %d\nCustomer Name: %s\nAmount: $%5.2f\nInterest Rate: %4.2f%%\nTerm: %d\nAmount Owed: $%8.2f\n----\n",
              BNKNAME, mortgageType, mortgageNumber, customerName, amountMortgage, interestRate * 100, term, getAmountOwed());
   }

}
