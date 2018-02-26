/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Design a Driverlotto class with one array instance variable to hold 
three random integer values (from 1 to 9). 
Include a constructor that randomly populates the 
array for a lotto object. 
Also, include a method in the class to return the array.
Use this class to simulate a simple lotto game in 
which the user chooses a number between 3 and 27. 
The user runs the lotto up to 5 times and each time the sum of lotto numbers is 
calculated. If the number chosen by the user matches the sum, 
the user wins and the game ends. If the number does not match 
the sum within five rolls, the computer wins.
Use methods of JOptionPane class to interact with the user.

 */
package exercise2;

/**Class to shows Play Lotto Game
* @author Fabio Alexandre Ciconi -- 300930909
* @version 1
* @since Release 10/02/2017
*/

public class Driverlotto 
{
   
   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) 
   {      
      Lotto play = new Lotto();
      play.game(); 
   }
}

  