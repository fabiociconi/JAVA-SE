
class Student {
	private String firstName;
	private String lastName;
	private String sid;
	
	Student(String fname, String lname, String id) throws Exception{
		this.firstName=fname.trim();
		this.lastName=lname.trim();
		this.sid=id.trim();
		Integer.parseInt(id);  //this will throw exception if the id is not an integer number
	}
	String getId(){
		return sid;
	}
	String getFirstName(){
		return this.firstName;
	}
	String getLastName(){
		return this.lastName;
	}
}
