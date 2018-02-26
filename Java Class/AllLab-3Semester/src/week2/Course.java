package week2;


class Course {
	private String courseId;  //default value is 'null' 
	private int sectionNum; //default value is 0
	
	/**
	 * 
	 * Constructor is defined 
	 * @param cid - course id
	 * @param snum - section number
	 */
	Course(String cid, int snum){
		courseId = cid;
		sectionNum=snum;
	}
	
	/**
	 *  Initializes instance variables 
	 */
	Course(){  //Default constructor defined by user
		courseId="Unknown";
		//'sections' default value will be 0
	}
	
	void setCourseId(String cid){
		courseId=cid;
	}
	
	String getCourseId(){
		return courseId;
	}
	
	//TODO add setter and getter for section
}
