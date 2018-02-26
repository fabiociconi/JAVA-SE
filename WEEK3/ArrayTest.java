
public class ArrayTest {
	public static void main(String args[])
	{
		doIntArrayTest();
		doStringArrayTest(args);
		
		DEmployee emps[] = createObjectArray();
		doObjectArrayTest(emps);
		
		
	}
	
	private static void doIntArrayTest(){
		int aInt[]; //a reference of array for int is declared (no array exist yet).
		//aInt[0] = 10;  //what would happen here?
		
		aInt = new int[3];  //create an array to store three integers
		aInt[0] = 900;
		aInt[1] = 1000;
		aInt[2] = 1100;
		
		//aInt[3]=1200;  - what if you execute this line?
		
		System.out.println("size of aInt is "+aInt.length);
		
		//idx is local variable to the 'for' loop
		//try loop as 'enhanced' for loop as in following method
		for (int idx=0; idx < aInt.length; idx++){
			System.out.printf("val=%d ..", aInt[idx]);
		}
		//idx = 90;  what if you try to use 'idx'
		System.out.println();
	}
	
	private static void doStringArrayTest(String vals[]){
		for(String val:vals){
			System.out.println("string="+val);
		}
	}
	//returning an array of references of DEmployee objects
	private static DEmployee[] createObjectArray(){
		DEmployee emps[] = new DEmployee[2];  //create an array that will hold three DEmployee object references
		DEmployee aemp = null;
		
		//create an object and set reference in the array -- Array index starts at '0'
		emps[0]= new DEmployee();
		emps[0].setData(1000);
		emps[0].setData("John");
		
		aemp= new DEmployee();
		aemp.setData(2000);
		aemp.setData("Jane");
		
		emps[1]=aemp; //set reference in the array	
		
		return emps;
	}
	private static void doObjectArrayTest(DEmployee emps[]){
		for(DEmployee val: emps){
			System.out.println("employee="+val.getData());
		}
	}
}


class DEmployee{
	private int id;  //object or instance variable, property
	private String name;
	
	//A Constructor is called first and only ONCE when object is created
	
	//default constructor defined and hence supplied by the compiler
	public DEmployee(){
		id = 0;
		name="";
	}
	//constructor overloading
	public DEmployee(int val){
		id = val;
		name=""; 
	}

	//constructor overloading
	public DEmployee(String val){
		id = 0;
		name=val; 
	}
	
	//multiple methods defined with different arguments
	public void setData(int val){
		id=val;
	}
	public void setData(String val){
		name=val;
	}
	public String getData(){
		return id+"-"+name;
	}
}
