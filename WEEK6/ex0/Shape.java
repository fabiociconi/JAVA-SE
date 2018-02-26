
abstract public class Shape {
	private String color = "White";
	
	abstract public void draw();
	
	final public String getColor(){
		return this.color;
	}
	final public void setColor(String color){
		this.color=color;
	}
}
