
public class EnumTest {
	public static final String author="John Doe";
	
	public static void main(String args[])
	{
		Room rm1 = new Room();
		System.out.println("room1 is open "+rm1.isDoorOpen());
		rm1.closeDoor();
		System.out.println("room1 is open "+rm1.isDoorOpen());
		rm1.openDoor();
		System.out.println("room1 is open "+rm1.isDoorOpen());
		
		// author="test";  declared final and cannot be changed
	}
}

enum State{
	OPEN, CLOSE
}

class Room{
	private State door = State.CLOSE;  
	
	boolean isDoorOpen(){
		if (door == State.OPEN){
			return true;
		}
		return false;
	}
	void closeDoor(){
		door = door.CLOSE;
	}
	void openDoor(){
		door = State.OPEN;
	}
}