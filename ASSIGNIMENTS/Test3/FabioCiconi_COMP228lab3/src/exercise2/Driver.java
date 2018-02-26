/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

import java.util.*;

/**
 *
 * @author ZeusAC
 */
public class Driver 
{

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) 
   {
      Scanner input = new Scanner(System.in);
      GameTester[] varArray = new GameTester[3];
      for (int i = 0; i < varArray.length; i++) 
      {
         System.out.println("\nName : ");
         String nameGamer = input.next();
         System.out.println("\nType of Contract (F or P): ");
         char type = input.next().charAt(0);
         
         switch (type) 
         {
            case 'F':
            case 'f': 
            {
               GameTester sd = new FullTimeGamer(nameGamer, true);
               varArray[i] = sd;
               System.out.printf("Name: %s\nType: Full Time\nSalary: $%.2f", nameGamer, sd.salaryGamer());
               break;
            }
            case 'P':
            case 'p': 
            {
               GameTester pt = new PartTimeGamer(nameGamer, false);
               varArray[i] = pt;
               System.out.println("How many hours ? :\n ");
               int qtdHour = input.nextInt();
               ((PartTimeGamer) pt).setQuantHour(qtdHour);
               System.out.printf("Name: %s\nType: Part Time\nSalary: $%.2f", nameGamer, pt.salaryGamer());
               break;
            }
            default:
               System.out.println("Please choose (f) Full Time or (p) Part_Time");
               i--;
               break;
         }
      }
   }
}
