/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise2;

import java.util.*;
import javax.swing.*;

/**Class to simulate Lotto Game
* @author Fabio Alexandre Ciconi -- 300930909
* @version 1
* @since Release 10/02/2017
*/
public class Lotto 
{
    private int lottoNumber[];
    private int numberChosen;
    private static final int TOTAL = 6;


   Lotto()
   {
     Random number = new Random();
     lottoNumber = new int[3]; //={number.nextInt(2),number.nextInt(2),number.nextInt(2)};
     for (int i = 0; i < 3; i++) // create a loop that executes 10 times
      {
        lottoNumber[i] = number.nextInt(9); // each execution through the loop
                                        // generates a new random number and
                                        // stores it in the array at the
                                        // position i of the for-loop
       
      }
      
      
   }

   /**
    *
    * @param number
    */
   public void setNumber(int number)
   {
      numberChosen = number;
   }

   /**
    *
    * @param numberchosen
    * @return
    */
   public int getNumber(int numberchosen)
   {
      return numberChosen = numberchosen;
   }

   /**
    *
    * @param num
    * @return
    */
   public int getLottoNumber(int num)
   {
      return lottoNumber[num];
   }   
      
   public void game()
   {
      //int luckNumber = 0;
      boolean checkWin = false;
      //int num1 = 0;
      //int num2 = 0;
      //int num3 = 0;
            
      int num1 = getLottoNumber(0);
      int num2 = getLottoNumber(1);
      int num3 = getLottoNumber(2);
      int soma = num1+num2+num3;
           
      
      for(int i=0; i < TOTAL; i++)
      {    
         String choose = JOptionPane.showInputDialog("Choose your Number");
         int luckNumber = Integer.parseInt(choose);
      
         this.setNumber(luckNumber);
      
         if (this.getNumber(numberChosen)> 2 && this.getNumber(numberChosen)< 28 )
         {
            if(soma != luckNumber)
            {   JOptionPane.showMessageDialog(null, "No choose other number!", 
                    "Attempts "+(i+1),JOptionPane.INFORMATION_MESSAGE);
            
            }else  
               {
                  JOptionPane.showMessageDialog(null,  "You win");
                  checkWin = true;
                  break;
               }
         }
         else
         { 
            JOptionPane.showMessageDialog(null,  "You have to choose a number between 3 and 27");
            i--;
         }
        
      }
      if (checkWin == false)
      {
              JOptionPane.showMessageDialog(null,  "Sorry - You Loose");
               JOptionPane.showMessageDialog(null, "Lotto Number was: "+num1+"-"+num2+"-"+num3
                 ,"Final Results",JOptionPane.INFORMATION_MESSAGE);
      }else
      {
          JOptionPane.showMessageDialog(null, "Lotto Number was: "+num1+"-"+num2+"-"+num3
                 ,"Final Results",JOptionPane.INFORMATION_MESSAGE);
      }
   }
}