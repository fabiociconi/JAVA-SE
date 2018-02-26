
public class MethodOverloadingTest {
	public static void main(String args[])
	{
		CEmployee emp = new CEmployee();
		emp.setData(1000);
		emp.setData("John");
	}
}

class CEmployee{
	private int id;  //object or instance variable, property
	private String name;
	
	//default constructor defined and hence supplied by the compiler
	public CEmployee(){
		id = 0;
		name="";
	}
	//constructor overloading
	public CEmployee(int val){
		id = val;
		name=""; 
	}

	//constructor overloading
	public CEmployee(String val){
		id = 0;
		name=val; 
	}
	
	//multiple methods defined with different arguments
	public void setData(int val){
		System.out.println("setting id");
		id=val;
	}
	public void setData(String val){
		System.out.println("setting name");
		name=val;
	}
	
	//write a method setData that takes both id and name

}
