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
public class FullTimeGamer extends GameTester
{
   private double salaryFullTimeBase;

   public FullTimeGamer(double salaryFullTimeBase, String gameTesterName, boolean statusGamer) {
      super(gameTesterName, statusGamer);
      this.salaryFullTimeBase = salaryFullTimeBase;
   }

   /**
    *
    * @param gameTesterName
    * @param statusGamer
    */
   public FullTimeGamer(String gameTesterName, boolean statusGamer) 
   {
      super(gameTesterName, statusGamer);
      this.salaryFullTimeBase = 3000.00;
   }

   @Override
   double salaryGamer()
   {
      return salaryFullTimeBase;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
   
}
