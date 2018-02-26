/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Write a driver class to test this hierarchy.
 * This application should ask the user to enter the type of insurance and its monthly fee.
 */
package exercise1;

import javax.swing.JOptionPane;

/**
 * 
 * @author ZeusAC
 */
public class Driver {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) 
   {

      //Health valuefee = new Health("Enter with monthly fee");
      Insurance[] insArray = new Insurance[4];

      for (int i = 0; i < 4; i++) 
      {
         String typeInsurance = JOptionPane.showInputDialog("Choose your Insurance: ").toUpperCase();
         double montlyValue = Double.valueOf(JOptionPane.showInputDialog("Montly Value: "));

         switch (typeInsurance) {
            case "LIFE":
               insArray[i] = new Life(typeInsurance, montlyValue);

               break;
            case "HEALTH":
               insArray[i] = new Health(typeInsurance, montlyValue);
               break;
            default:
               JOptionPane.showMessageDialog(null, "Insert life or health: ", "Warning ", JOptionPane.WARNING_MESSAGE);
               i--;
               break;
         }
      }
      //test Instanceof
      for (Insurance i : insArray) {
         if (i instanceof Life) {
            JOptionPane.showMessageDialog(null, "Instance of life", "Test of Instance ", JOptionPane.WARNING_MESSAGE);
         } else {
            JOptionPane.showMessageDialog(null, "Instance of health", "Test of Instance ", JOptionPane.WARNING_MESSAGE);
         }
         i.displayInfo();

      }

   }

}
