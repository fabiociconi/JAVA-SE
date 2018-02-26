/**
	This class test "class" variable and "class" method.
*/
public class ClassMethodTest
{
	/**
		Entry point to the program.
		@param args - command line arguments.
	*/
	public static void main(String args[])
	{
		//Calling class method before creating object
		System.out.println("1. value of getTotal="+PTEmployee.getTotal());//==1
		PTEmployee st = null;  //Declare references
		st = new PTEmployee();  //Create object
		st.setId(1);
		
		//calling class method using object reference
		System.out.println("2. value of getTotal="+st.getTotal());//==3
	}
}

class PTEmployee
{
	//class or static variables
	private static int total; //implicit initialization
	static int MAX = 50; //explicit initialization
	
	private int id = -1; //Object variable - Explicity initialization
	void setId(int i){ 
		id = i; 
		total++; //OK to access static/class variables  -  this is same as total=total+1
		//getTotal(); //ok to call static/class methods
	}
	//class method
	static int getTotal() 
	{  
	   total++; //OK to access static/class variable
	   //id = 0; //Not-OK to access object variable
	   //setId(10);  not ok to call instance method
	   return total;
	}
}
