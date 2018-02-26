package week6;


public class SimpleInterfaceTest {
	public static void main(String s[])
	{
		Trucker t = new Trucker();
		t.drive();
		
		Postalworker p = new Postalworker();
		
		Driver dr[] = new Driver[2];
		dr[0] = t;
		dr[1] = p;
		
		testDrive(dr);
		
	}
	private static void testDrive(Driver dr[]){
		for(Driver d:dr){
			d.drive();
		}
	}
}

interface Driver
{
	//its implied static
	final int MAX_WHEELS=10;
	
	
	//implied "public"
	void drive();
}


class Trucker implements Driver
{
	//interface methods MUST be public
	public void drive()
	{
		System.out.println("driving truck");
	}
}

class Postalworker implements Driver
{
	//interface methods MUST be public
	public void drive()
	{
		System.out.println("driving postal truck");
	}
}