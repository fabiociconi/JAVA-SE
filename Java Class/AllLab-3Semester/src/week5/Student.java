package week5;


public class Student extends Person{
	private final String id;
	
	public Student(){
		//default constructor of super/parent class is automatically called
		id="";
	}
	
	public Student(String id, String name){
		super(name);  //calling constructor of super class - must be first statement
		this.id = id;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getInfo(){
		return this.id + getName();//calling getName from super class.
	}
}
