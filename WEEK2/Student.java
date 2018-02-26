/**
 * 
 * The purpose of the class is to illustrate simple Java class
 * @author John Doe
 *
 */
public class Student
{
	private int id;  //object or instance variable, property
	
	//default constructor not defined and hence supplied by the compiler
		
	public void setId(int i)  //object or instance method - behavior - setter method
	{ 
		id = i;
		
		boolean ok = isIdOk();
		if (ok){
			System.out.println("Id is ok");
		}else{
			System.out.println("Id is NOT ok");
		}
		
	}
	public int getId(){
		return id;
	}
	
	/*
	 * Private method can be called only within this class by other methods
	 */
	private boolean isIdOk(){
		if (id > 0){
			return true;
		}else{
			return false;
		}
	}
	
}
