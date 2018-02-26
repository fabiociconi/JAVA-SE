/**  ThisTest.java
   	To learn: 
    	1) to "this" reference and use of it
*/

//only one public class per .java file
public class ThisTest
{
	public static void main(String s[])
	{
		Student st = new Student("John Smith", 10001);
		st.setID(99000);
		st.printID();
	}
}
 
class Student 
{
	private int id ;
	private String name;
	
	Student(String fullname, int id){
		this.id=id;  
		name=fullname;
	}
	
	public void setID(int id)
	{
		//"this" refers to the object which called current method
		//think what would happen if we do not use 'this'
		this.id = id;
	}
	public void printID() 
	{
		System.out.println("id="+id);  //no conflict and hence no need to use 'this'
	}
}