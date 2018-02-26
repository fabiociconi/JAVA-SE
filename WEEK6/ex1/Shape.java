
public class Shape {
	private String color = "White";
	
	public void draw(){
		System.out.println("Drawing shape with color = "+getColor());
	}
	
	public String getColor(){
		return this.color;
	}
	public void setColor(String color){
		this.color=color;
	}
}
