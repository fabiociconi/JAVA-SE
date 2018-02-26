/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise3;

import java.util.Scanner;

/**
 *
 * @author ZeusAC
 */
public class ProcessMortgage 
{

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) 
   {
      Mortgage[] array = new Mortgage[1];
      Scanner input = new Scanner(System.in);

      for (int i = 0; i < 1; i++) {
         System.out.println("Please Mortgage Type(P) or (B):\n ");
         char morgageType = input.next().charAt(0);
         
         System.out.println("Please your name :\n ");
         String newCustomerName = input.next();

         System.out.println("Please Enter Amount Mortgage :\n ");
         double newAmount = input.nextDouble();

         System.out.println("Please Term(1 or 3 or 5) years :\n ");
         int newTerm = input.nextInt();

         if (morgageType == 'P' || morgageType == 'p') 
         {
            array[i] = new PersonalMortgage(morgageType, (i + 1), newCustomerName, newAmount, newTerm);
         } else 
         {
            array[i] = new BusinessMortgage(morgageType, (i + 1), newCustomerName, newAmount, newTerm);
         }

      }
      for (Mortgage a : array) {
         a.getMortgageInfo();
      }
   }

}
