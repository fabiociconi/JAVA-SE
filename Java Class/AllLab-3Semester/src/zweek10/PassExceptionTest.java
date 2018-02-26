package zweek10;


public class PassExceptionTest {
	//main method does not catch the exception and passes it by declaring it to be throwing the exception
	public static void main(String[] args) throws Exception{
		calculator5 calc = new calculator5();
		System.out.println(" aveage1= " + calc.average(10, 5));
		System.out.println(" aveage2= " + calc.average(10, 0));
		System.out.println("Done");
	}
}

class InvalidDataException5 extends Exception {
	InvalidDataException5(String s) {
		super(s);
	}
}

class calculator5 {
	// following method throws 'Checked' exception that must be handled
	double average(int total, int count) throws InvalidDataException5 {
		if (count == 0) {
			throw new InvalidDataException5("Invalid count param");
		}
		return total / count;
	}
}
