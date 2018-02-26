package week3;

/**
 * 
 * The purpose of the class is to illustrate simple Java class
 * @author John Doe
 *
 */
public class Student
{
	private int id;  //object or instance variable, property
	private String name;
	
	//default constructor defined and hence not supplied by the compiler
	public Student(){
		id = 100;
		name="";
	}
	
	public Student(int val){
		id = val;
		name=""; 
	}
	
	//multiple params, separated by comma
	public void setData(int i, String fname){
		id = i;
		name=fname;
	}
		
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
	public String getData(){
		return id+" "+name;  //when string is added with other types, it converts it to string
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
