import java.util.EnumSet;

public class EnumTest {

	public static void main(String args[]){
		System.out.println(Province.ON);
		System.out.println(Province.ON.getLocation());
		System.out.println(Province.ON.getName());	
		
		for(Province prov: EnumSet.range(Province.ON, Province.PQ)){
			System.out.println("--:"+prov.getName());	
		}
	}
}


enum Province{
	ON("Ontario", "East"),
	PQ("Quebec", "East"),
	AB("Albert", "West");
	
	private final String name;  //because its final, must be initialized in constructor or here
	private final String location;
	
	Province(String name, String loc){
		this.name=name;
		this.location=loc;
	}
	
	public String getName(){
		return this.name;
	}
	public String getLocation(){
		return this.location;
	}
	
}