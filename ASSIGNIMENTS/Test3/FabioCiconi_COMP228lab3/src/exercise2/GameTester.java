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
abstract public class GameTester 
{
 private String gameTesterName;
 private boolean statusGamer;
 
   /**
    *
    * @param gameTesterName
    * @param statusGamer
    */
   public GameTester(String gameTesterName, boolean statusGamer)
   {
      this.gameTesterName = gameTesterName;
      this.statusGamer = statusGamer;
   }
 
   //abstract void setQuantHour();
   abstract double salaryGamer();
           
}
