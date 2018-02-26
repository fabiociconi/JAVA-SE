
public class PolymorphismTest {
	
	public static void main(String args[]){
		//Shape s = new Shape();
		//drawShape(s);
		
		Ellipse e = new Ellipse();
		drawShape(e);
		
		Square sq = new Square(10);
		sq.setColor("blue");
		drawShape(sq);
		
		Rectangle rect = new Rectangle(10,30);
		rect.setColor("red");
		drawShape(rect);
	}
	
	private static void drawShape(Shape sh){
		sh.draw();
	}

}
