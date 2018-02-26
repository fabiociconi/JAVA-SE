
public class ExceptionTest1 {
	   public static void main(String[] args) {
		   calculator calc = new calculator();
		   System.out.println(" aveage1= "+calc.average(10, 5));
		   System.out.println(" aveage2= "+calc.average(10, 0));
		   System.out.println("Done");
		   
		   Object obj = calc;
		   //following will cause ClassCastException
		   //String str = (String)obj;
		   
		   int iarray[] = new int[2];
		   //following will cause ArrayIndexOutOfBoundsException–
		   //iarray[3] = 2;
	   }
}



class calculator{
	/*
	 * This method will throw ArithmeticException exception if count = 0
	 */
	double average(int total, int count) {
		return total/count;
	}
}