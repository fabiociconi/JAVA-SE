import java.io.IOException;

public class FinallyTest {
	//main method does not catch IOException and passes it on
	public static void main(String[] args) throws IOException{
		calculator6 calc = new calculator6();
		try {
			System.out.println(" aveage1= " + calc.average(10, 5));
			System.out.println(" aveage2= " + calc.average(10, -1));
		}catch (InvalidDataException6 ie6){
			System.out.println("Exception thrown = "+ie6.getMessage());
		}
		//following will always execute, if exception is thrown or not
		finally{
			System.out.println("Done");
		}
	}
}

class InvalidDataException6 extends Exception {
	InvalidDataException6(String s) {
		super(s);
	}
}

class calculator6 {
	// following method throws two 'Checked' exception that must be handled
	double average(int total, int count) throws InvalidDataException6, IOException {
		if (count == 0) {
			throw new InvalidDataException6("Invalid count param");
		}
		if (count < 0){
			throw new IOException("value must be > 0");
		}
		return total / count;
	}
}
