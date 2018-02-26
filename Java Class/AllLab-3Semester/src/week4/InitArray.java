/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4;


public class InitArray
{
 public static void main(String[] args)
{
   // declare variable array and initialize it with an array object
   int[] array = new int[10]; // create the array object
   System.out.printf("%s%8s%n", "Index", "Value"); // column headings
   
   // output each array element's value
   for (int counter = 0; counter < array.length; counter++)
   System.out.printf("%5d%8d%n", counter, array[counter]);
} 
}