package week4;

import java.io.IOException;

public class ExceptionTest
{
	public static void main(String s[])
	{
		Utility obj = new Utility();
		
		try 
		{
			int val = obj.calculateAverage(20, 4);//exception is NOT thro
			System.out.printf("1--Average is %d%n", val);

			obj.calculateAverage(20, 0); //exception is thrown
			System.out.printf("2--Average is %d%n", val);
		}
		catch (IOException e)
		{
			System.out.println("Exception caught");
			System.out.println("Message="+e.getMessage());
		}
 		System.out.println("After catch.");
      
	}
}