/*
* Write a Java class that implements a set of three overloaded static methods. 
* The methods should have different set of parameters and perform similar 
* functionalities. Call the methods within main method and display the results.
 */
package exercise3;
//import javax.swing.JOptionPane;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
/**Class to shows overloaded use
* @author Fabio Alexandre Ciconi -- 300930909
* @version 1
* @since Release 10/02/2017
*/
public class Overloaded 
{

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) 
   {      
       System.out.println("Overloading - BEGIN PROGRAM");       
       System.out.println("AREA SQUARE    " +OverloadingCalculation.calcArea(2));  
       System.out.println("AREA TRIAGLE:  " +OverloadingCalculation.calcArea(3,4));  
       System.out.println("Area Circle    " +OverloadingCalculation.calcArea(3.3));
       System.out.println("Overloading - END PROGRAM");
       //JOptionPane.showMessageDialog(null,OverloadingCalculation.setArea(2)+OverloadingCalculation.setArea(3.3)+
       //        OverloadingCalculation.setArea(3,4), "Results", JOptionPane.INFORMATION_MESSAGE);
            
   }  

}
/**Class to calculate areas
* @author Fabio Alexandre Ciconi -- 300930909
* @version 1
* @since Release 10/02/2017
*/
class OverloadingCalculation
{
   /**
   * Calculate Area
   * @param num - side
   * @return Square are
   */
   public static int calcArea(int num)
   {
     
      return num*num;           
   }
   /**
   * Calculate Area
   * @param num1 - side
   * @param num2 - height
   * @return Triangle area
   */
   public static int calcArea(int num1, int num2)
   {
      
      return (num1*num2)/2;      
      
   }
   /**
   * Calculate Area
   * @param num1 - side
   * @return Circle are
   */
      public static double calcArea(double num1)
   {
     
      return (num1*num1)*Math.PI;      
      
   }
}