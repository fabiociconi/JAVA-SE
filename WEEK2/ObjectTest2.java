
public class ObjectTest2 {

	public static void main(String[] args) {
		Student st = null;  //Declare reference  - local variable of user defined type
		int id1;  //local variable of primitive type  - must be initialized before use
		
		st = new Student();  //Create object  - default constructor will be called
		System.out.println("Student id="+st.getId());
		
		id1=100;  //local variable assigned value
		st.setId(id1); //calling student object's method
		System.out.println("Student id="+st.getId());
		
		//creating new student object and saving reference to 'st'.  Now we cannot get previous 
		//object-it will be garbage collected - i.e memory will be cleaned up and recovered
		st = new Student();
		st.setId(200);
		System.out.println("Student id="+st.getId());
	}

}
