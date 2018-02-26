package week6;

/*
  Illustrates: 
  1) upcast to interface
  2) interface extending more than one interface
  3) Calling method using interface handle.

*/
public class InterfaceTest
{
	public static void main(String s[])
	{
		MyBike mb = new MyBike();

		//upcast to interface
		Moveable mv = mb;
		mv.move();
		
		//try this mv.buy();
		
		mb.buy();
		mb.park();

	}
}

interface Moveable
{
	void move();
}

interface Affordable
{
	void buy();
}

// interface extending more than one interface
// Cannot do this for classes
interface bike extends Moveable, Affordable
{
	void ride();
}

class MyBike implements bike
{
	//interface methods MUST be public
	public void move()
	{
		System.out.println("move");
	}
	public void buy()
	{
		System.out.println("buy");
	}
	public void ride()
	{
		System.out.println("ride");
	}
	void park()
	{
		System.out.println("park");
	}

}