
public class ObjectTest3 {

	public static void main(String[] args) {
		//object is created with non-default constructor
		Course course1 = new Course("comp228", 3);
		
		System.out.printf("The course %s is Java ", course1.getCourseId());
		
		course1 = null; //we lost reference now i.e lost the object
		//what if you try following now
		//System.out.printf("The course %s is Java ", course1.getCourseId());
	}
}