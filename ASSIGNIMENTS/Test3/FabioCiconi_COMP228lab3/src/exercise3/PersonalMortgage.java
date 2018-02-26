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
public class PersonalMortgage extends Mortgage 
{
   /**
    *
    * @param mortgageType
    * @param mortgageNumber
    * @param customerName
    * @param amountMortgage
    * @param term
    */
   public PersonalMortgage(char mortgageType, int mortgageNumber, String customerName, 
                           double amountMortgage, int term) 
   {
      super(mortgageType, mortgageNumber, customerName, amountMortgage, term);
      interestRate = 0.02;
   }

}
