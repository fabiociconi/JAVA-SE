package week3;


public class Test1 {
	public static void main(String args[])
	{
		Student st = null;  //Declare reference  - local variable of user defined type
		//st.setId(200);
		
		st = new Student();
		st.setData(300, "john");
		System.out.println("Student is "+st.getData());
	}
}
