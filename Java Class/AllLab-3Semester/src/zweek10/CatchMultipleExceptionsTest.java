package zweek10;


public class CatchMultipleExceptionsTest {
	   public static void main(String[] args) {
		   calculator4 calc = new calculator4();
		   try {
			   System.out.println(" aveage1= "+calc.average(10, 5));
			   
			   int array[] = new int[2];
			   array[3] = 10; //will cause array index out of bounds exception
			   
			   System.out.println(" aveage2= "+calc.average(10, 0));
		   }
		   catch(Exception ie){
			   System.out.println("Exception caught - message "+ie.getMessage());
			   ie.printStackTrace();
			   System.out.println("");
		   }
		   System.out.println("Done");
	   }
}




class InvalidDataException2 extends Exception{
	InvalidDataException2(String s){
		super(s);
	}
}

class calculator4{
	// following method throws 'Checked' exception that must be handled
	double average(int total, int count) throws InvalidDataException2 {
		if (count == 0){
			throw new InvalidDataException2("Invalid count param");
		}
		return total/count;
	}
}
