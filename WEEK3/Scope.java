public class Scope {
	// field that is accessible to all methods of this class
	private static int x = 1;

	// method main creates and initializes local variable x
	// and calls methods useLocalVariableand useField
	public static void main(String[] args) {
		int x = 5; // method's local variable x shadows field x
		System.out.printf("local x in main is %d%n", x);
		useLocalVariable(); // useLocalVariablehas local x
		useField(); // useFielduses class Scope's field x
		useLocalVariable(); // useLocalVariablereinitializes local x
		useField(); // class Scope's field x retains its value
		System.out.printf("%nlocalx in main is %d%n", x);
	}

	// create and initialize local variable x during each call
	public static void useLocalVariable() {
		int x = 25; // initialized each time useLocalVariableis called
		System.out.printf("%nlocalx on entering method useLocalVariableis %d%n", x);
		++x; // modifies this method's local variable x
		System.out.printf("local x before exiting method useLocalVariableis %d%n", x);
	}

	// modify class Scope's field x during each call
	public static void useField() {
		System.out.printf("%nfieldx on entering method useFieldis %d%n", x);
		x *= 10; // modifies class Scope's field x
		System.out.printf("field x before exiting method useFieldis %d%n", x);
	}
} // end class Scope