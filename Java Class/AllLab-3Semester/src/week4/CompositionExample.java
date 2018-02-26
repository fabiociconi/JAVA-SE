package week4;


/**  CompositionExample.java
   	To learn: Composition of object
    	
*/
public class CompositionExample {
	public static void main(String s[])
	{
		CStudent st = new CStudent("John Smith", 10001);
		Course comp1 = new Course("COMP228", 3);
		st.addCourse(comp1);
		st.printInfo();
	}
}


class Course{
	private String name;
	private int section;

   //constructor
	Course(String name, int sec)
   {
		this.name=name;
		this.section=sec;
	}
	String getInfo(){
		return name+"-"+section;
	}
	
}

/**
 * CStudent has a Course
 * @author java
 *
 *  TODO suggestion for exercise - instead of one course, change code to add 5 courses
 */
class CStudent 
{
	private int id ;
	private String name;
	private Course course1;
	//constructor
	CStudent(String fullname, int id){
		this.id=id;  
		name=fullname;
	}
	void addCourse(Course c){
		course1=c;
	}
	void printInfo(){
		System.out.printf("Student %s id=%d course %s%n", 
				name, id, course1.getInfo());
	}
}