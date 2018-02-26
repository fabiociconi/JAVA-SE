
public class PolymorphismTest2 {
	public static void main(String args[]){
		
		Shape sarray[] = new Shape[4];
		
		sarray[0]= new Shape();
		sarray[1] = new Ellipse();
		
		sarray[2] = new Square(10);
		sarray[2].setColor("blue");
		
		sarray[3] = new Rectangle(10,30);
		sarray[3].setColor("red");
		
		drawShapes(sarray);
	}
	
	private static void drawShapes(Shape sarry[]){
		for (Shape sh:sarry){
			sh.draw();
		}
	}
}
