/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4;

public class InitArray2
{
   public static void main(String[] args)
  {
     // initializer list specifies the initial value for each element
     int[] array = { 32, 27, 64, 18, 95, 14, 90, 70, 60, 37 };
      System.out.printf("%s%8s%n", "Index", "Value"); // column headings
   
      // output each array element's value
      for (int counter = 0; counter < array.length; counter++)
      System.out.printf("%5d%8d%n", counter, array[counter]);
} 

}
