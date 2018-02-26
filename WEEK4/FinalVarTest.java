
public class FinalVarTest {

}


//why have final var? In some logic, once you have value, you don't want to allow to
//change it
class Account{
	private final int id; //must be initilized here or in constructor
	private String name;
	
	
	Account(int id, String name){
		this.name=name;
		this.id=id;
	}
}