package week6;


public class Rectangle extends Shape{
	private int w, h;
	
	public Rectangle(int w, int h){
		this.w=w;
		this.h=h;
	}
	public void draw(){
		System.out.printf("Drawing Rectangle with color=%s w=%d h=%d",getColor(), w, h);
	}
}
