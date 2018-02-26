/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import javax.swing.JOptionPane;

/**
 *
 * @author ZeusAC
 */
public class Life extends Insurance {

   //private double valueLife; // value
   //private String coveredLife= "Life Insurece Converd for 10 years";
   /**
    *
    * @param typeInsurance
    * @param monthlyCost
    */
   public Life(String typeInsurance, double monthlyCost) {
      super(typeInsurance, monthlyCost);
   }

   /**
    *
    */
   @Override
   public void displayInfo() {
      JOptionPane.showMessageDialog(null, "Insurance Type: " + getTypeInsurance() + " Montly Value : " + getMonthlyCost(), "Insurance Info", JOptionPane.INFORMATION_MESSAGE);

   }

}
