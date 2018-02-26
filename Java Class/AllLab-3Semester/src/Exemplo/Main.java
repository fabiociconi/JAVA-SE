package Exemplo;

public class Main 
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		double radiusCircle = 3;
		int lengthRectangle = 10;
		int widthRectangle = 15;
		int heightCylinder = 20;
		double raidusCylinder = 4;
		
		System.out.println ("The area of a circle with radius " + radiusCircle +
				" is " + Area.Area(radiusCircle));
		System.out.println ("The area of a rectangle with a lenght of " + 
				lengthRectangle + " and a width of " + widthRectangle +
				" is " + Area.Area(widthRectangle, lengthRectangle));
		System.out.println ("The area of a cylinder with a radius " + raidusCylinder +
				" and a height of " + heightCylinder + " is " +
				Area.Area(raidusCylinder, heightCylinder));
		
	}
} 

