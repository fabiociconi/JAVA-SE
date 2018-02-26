package week8;

/**
 * A simple example to show static and non-static inner class
 * 
 * @author java
 *
 */
public class InnerClassTest {

	public static void main(String args[]){
		Outer obj1 = new Outer();
		obj1.method1();
		
		//explicitly create object of inner class using object of outer class and call method
		Outer.Inner1 obj2 = obj1.new Inner1();
		obj2.method1_inner1();
		
		//Private inner class Inner3 cannot be accessed using Outer.Inner3
		
		//static Inner class object created using class name of the Outer
		Outer.Inner2 obj4 = new Outer.Inner2();
		obj4.method1_inner2();
		
	}
}


class Outer{
	private String str = "hello from outer class";
	
	
	void method1(){
		Inner1 obj = new Inner1();
		obj.method1_inner1();
		
		Inner3 obj2 = new Inner3();
		obj2.method1_inner3();
	}
	//inner class defined
	class Inner1{
		void method1_inner1(){
			System.out.println("Inner1: can see "+str); //private data of outer class can be accessed
		}
	}
	
	static class Inner2{
		void method1_inner2(){
			//System.out.println("can see "+str); //because class is static it canot see Outer's instance data
			System.out.println("In method of static inner class");
		}		
	}
	
	//private inner class defined
	private class Inner3 {
		void method1_inner3(){
			System.out.println("Inner3: can see "+str); //private data of outer class can be accessed
		}
	}

	
}