package zweek13;

/**
 * This code illustrates use of hashtable
 * 
 * @author java
 *
 */

import java.util.Hashtable;

public class HashtableTest {
	public static void main(String[] args) {
		Hashtable<String, Student> table = new Hashtable<>();		
		Student st = new Student("17-200", 50);
		table.put(st.getId(), st);
		
		st = new Student("18-300", 55);
		table.put(st.getId(), st);
		
		st = new Student("22-300", 88);
		table.put(st.getId(), st);
		
		
		st = new Student("44-300", 89);
		table.put(st.getId(), st);		
		
		//find student in the table
		st = table.get("22-300");
		System.out.println("Student marks "+st.getMarks());
		
		//TODO explore other methods of Hashtable
	}
}

class Student{
	private String id;
	private int marks;
	
	Student(String id, int marks){
		this.id=id;
		this.marks=marks;
	}
	int getMarks(){
		return marks;
	}
	String getId(){
		return id;
	}
}
