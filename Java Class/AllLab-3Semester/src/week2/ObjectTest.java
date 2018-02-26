package week2;

/**
 * This is a test/driver class 
 * 
 * @author java
 *
 */

public class ObjectTest
{
	/**
		Entry point to the program.
		@param args - command line arguments.
	*/
	public static void main(String args[])
	{
		Student st = null;  //Declare reference  - local variable of user defined type
		
		st = new Student();  //Create object  - default constructor will be called
		System.out.println("Student id="+st.getId());
		
		st.setId(100); //calling student object's method
		System.out.println("Student id="+st.getId());
		
	}
}
