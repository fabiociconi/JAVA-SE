
public class Square extends Rectangle {
	public Square(int len){
		super(len, len);
	}
	public void draw(){
		System.out.printf("Drawing square with color=%s%n", getColor());
	}
}
