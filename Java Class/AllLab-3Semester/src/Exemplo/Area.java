package Exemplo;

public class Area
{
	static double Area (double rad)
	{
		return Math.PI* (rad * rad);
	}
	
	
	static int Area (int wid, int len)
	{
		return wid * len;
	}
	
	static double Area (double rad, double heig)
	{
		return Math.PI * (rad * rad) * heig;
	}
}