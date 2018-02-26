package week6;


public class PolymorphismTest2 {
	public static void main(String args[]){
		
		Shape sarray[] = new Shape[3];
		
		sarray[0] = new Ellipse();
		
		sarray[1] = new Square(10);
		sarray[1].setColor("blue");
		
		sarray[2] = new Rectangle(10,30);
		sarray[2].setColor("red");
		
		drawShapes(sarray);
	}
	
	private static void drawShapes(Shape sarry[]){
		for (Shape sh:sarry){
			sh.draw();
		}
	}
}
