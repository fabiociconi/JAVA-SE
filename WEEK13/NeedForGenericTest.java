/**
 * This code illustrates needs/case for generics
 * @author java
 *
 */

import java.util.ArrayList;

public class NeedForGenericTest {
	public static void main(String args[]){
		ArrayList list= new ArrayList();
		list.add("hello");
		
		String str = (String)list.get(0); //must cast - why?
		list.add(new Integer(0));  //Allows to add object of Integer as well
		
		//with generics
		ArrayList<String> list2= new ArrayList<String>();
		list2.add("hello");
		str = list2.get(0);  //no casting
		//list2.add(new Integer(10));  t//ry uncommenting - will not allow to add Integer object
	}
}
