
public class CustomExceptionClassTest {
	   public static void main(String[] args) {
		   calculator3 calc = new calculator3();
		   try {
			   System.out.println(" aveage1= "+calc.average(10, 5));
			   System.out.println(" aveage2= "+calc.average(10, 0));
		   }
		   catch(InvalidDataException ide){
			   System.out.println("InvalidDataException caught - message "+ide.getMessage());
		   }
		   catch(Exception ie){
			   System.out.println("Exception caught - message "+ie.getMessage());
		   }
		   System.out.println("Done");
	   }
}




class InvalidDataException extends Exception{
	InvalidDataException(String s){
		super(s);
	}
}

class calculator3{
	// following method throws 'Checked' exception that must be handled
	double average(int total, int count) throws InvalidDataException {
		if (count == 0){
			throw new InvalidDataException("Invalid count param");
		}
		return total/count;
	}
}
