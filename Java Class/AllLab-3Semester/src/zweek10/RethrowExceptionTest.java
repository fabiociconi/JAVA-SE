package zweek10;

import java.io.IOException;

public class RethrowExceptionTest {
	public static void main(String[] args) throws InvalidDataException7, IOException{
		calculator7 calc = new calculator7();
		try {
			System.out.println(" aveage1= " + calc.average(10, 5));
			System.out.println(" aveage2= " + calc.average(10, -1));
		}catch (InvalidDataException7 ie7){
			System.out.println("Exception thrown = "+ie7.getMessage());
			//rethrowing the same exception
			throw ie7;
		}catch(IOException ee){
			//creating new exception and throwing it
			throw new IOException("Just did the test");
		}
		//following will always execute, if exception is thrown or not
		finally{
			System.out.println("Done");
		}
	}
}

class InvalidDataException7 extends Exception {
	InvalidDataException7(String s) {
		super(s);
	}
}

class calculator7 {
	// following method throws two 'Checked' exception that must be handled
	double average(int total, int count) throws InvalidDataException7, IOException {
		if (count == 0) {
			throw new InvalidDataException7("Invalid count param");
		}
		if (count < 0){
			throw new IOException("value must be > 0");
		}
		return total / count;
	}
}
