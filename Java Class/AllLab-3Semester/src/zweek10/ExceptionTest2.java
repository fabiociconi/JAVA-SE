package zweek10;

import java.io.IOException;

public class ExceptionTest2 {
	   public static void main(String[] args) {
		   calculator2 calc = new calculator2();
		   try {
			   System.out.println(" aveage1= "+calc.average(10, 5));
			   System.out.println(" aveage2= "+calc.average(10, 0));
		   }
		   catch(Exception ie){
			   System.out.println("Exception occured - message "+ie.getMessage());
		   }
		   System.out.println("Done");
		   
		   Object obj = calc;
		   //following will cause ClassCastException - which is an un-checked exception and does not need to be handled
		   //String str = (String)obj;
		   
		   int iarray[] = new int[2];
		   //following will cause ArrayIndexOutOfBoundsException�
		   //iarray[3] = 2;
	   }
}



class calculator2{
	// following method throws 'Checked' exception that must be handled
	double average(int total, int count) throws Exception {
		if (count == 0){
			throw new Exception("Invalid count");
		}
		return total/count;
	}
}