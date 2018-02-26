
/**
 *  This code illustrates defining a class using generics
 */
public class SimpleGenerics {
	public static void main(String args[]){
		Device<String> d1 = new Device<String>("123");
		System.out.println("d1 id="+d1.getId());
		
		Device<Integer> d2 = new Device<Integer>(new Integer(200));
		System.out.println("d2 id="+d2.getId());
	}
}


class Device <T>{
	private T id;
	
	Device(T t){
		this.id = t;
	}
	T getId(){
		return id;
	}
}