/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 *
 * @author ZeusAC
 */
public class PartTimeGamer extends GameTester{
   private double salaryPartTimeHour;
   private int    quantHour;

   /**
    *
    * @param salaryPartTimeHour
    * @param quantHour
    * @param gameTesterName
    * @param statusGamer
    */
   public PartTimeGamer(double salaryPartTimeHour, int quantHour, String gameTesterName, boolean statusGamer) 
   {
      super(gameTesterName, statusGamer);
      this.salaryPartTimeHour = salaryPartTimeHour;
      this.quantHour = quantHour;
   }

   public void setQuantHour(int quantHour) {
      this.quantHour = quantHour;
   }
   
   /**
    *
    * @param gameTesterName
    * @param statusGamer
    */
   public PartTimeGamer(String gameTesterName, boolean statusGamer) 
   {
      super(gameTesterName, statusGamer);
      this.salaryPartTimeHour = 20.00;
   }

   
   @Override
   double salaryGamer() 
   {
     return salaryPartTimeHour*quantHour;
   }
   
}
