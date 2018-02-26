/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

/**
 *
 * @author ZeusAC
 */
abstract public class Insurance {

   private final String typeInsurance;
   private final double monthlyCost;

   /**
    *
    * @param typeInsurance
    * @param monthlyCost
    */
   public Insurance(String typeInsurance, double monthlyCost) 
   {
      this.typeInsurance = typeInsurance;
      this.monthlyCost = monthlyCost;
   }

   /**
    * @return the typeInsurance
    */
   public String getTypeInsurance() 
   {
      return typeInsurance;
   }

   /**
    * @return the monthlyCost
    */
   public double getMonthlyCost() 
   {
      return monthlyCost;
   }

   /**
    *
    */
   abstract public void displayInfo();

}
