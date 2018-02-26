package week3;


/**
	This class test "class" variables.
*/
public class ClassVariableTest
{
	/**
		Entry point to the program.
		@param args - command line arguments.
	*/
	public static void main(String args[])
	{
		Employee st = null;  
		Employee st2 = null; //Declare references
		
		st = new Employee();  //Create object
		st.setId(1);
		System.out.println("1.total objects="+Employee.total);
		st2 = new Employee();
		st2.setId(3);
		System.out.println("2.total objects="+st.total);
	}
}

class Employee
{
	//class or static variables
	static int total; //implicit initialization
	static int MAX = 50; //explicit initialization
	
	private int id = -1; //Object variable - Explicity initialization
	void setId(int i){ 
		id = i; 
		total++;
	}
}