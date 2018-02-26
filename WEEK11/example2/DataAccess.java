package example2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class DataAccess {
	private PreparedStatement findStudentStmt, updateStudentStmt, addStudentStmt, findCourseStmt, addCourseStmt;
	private Connection conn;
	private ResultSet resultset;

	DataAccess() throws Exception {
		// for uid, pass, put your uid and pass
		conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD", Consts.uid,
				Consts.pass);
		findStudentStmt = conn.prepareStatement("SELECT * FROM student WHERE rtrim(sid) = ? ");
		updateStudentStmt = conn
				.prepareStatement("UPDATE student SET student.first_name = ?, student.last_name = ? WHERE rtrim(student.sid) = ?");
		addStudentStmt = conn.prepareStatement("INSERT into student values (?, ?, ?)");
		findCourseStmt = conn.prepareStatement("SELECT course_code from student_course where rtrim(sid) = ?");
		addCourseStmt = conn.prepareStatement("INSERT into student_course values (?, ?)");

		System.out.println("Connected to JDBC");
	}

	Student findStudent(String id) throws Exception {
		Student st = null;
		findStudentStmt.setString(1, id);
		resultset = findStudentStmt.executeQuery();
		if (resultset != null) {
			if (resultset.next()) {
				String fname = resultset.getString(2); // using index
				String lname = resultset.getString("last_name"); // using column-name
				String 	courses[] = findStudentCourses(id);												
				
				st = new Student(fname, lname, id, courses);

			}
			resultset.close();
			return st;
		} else {
			throw new Exception("Cannot find record.");
		}
	}
	
	private String[] findStudentCourses(String id){
		ArrayList<String> alist = new ArrayList<String>();
		 try {
			 findCourseStmt.setString(1, id);
			 resultset = findCourseStmt.executeQuery();
			 
				if (resultset != null) {
					while (resultset.next()) {
						String cid = resultset.getString("course_code"); // using index
						alist.add(cid);
					}
					resultset.close();
					String courses [] = new String[alist.size()];
					return alist.toArray(courses);
				}else{
					return new String[0];  //return empty array
				}
		 }catch (Exception ee){
			 return new String[0];  //return empty array
		 }
	}
	
	void updateStudent(Student st) throws Exception {
		updateStudentStmt.setString(1, st.getFirstName());
		updateStudentStmt.setString(2, st.getLastName());
		updateStudentStmt.setString(3, st.getId());
		updateStudentStmt.executeUpdate();
	}

	void addStudent(Student st) throws Exception {
		addStudentStmt.setString(1, st.getId());
		addStudentStmt.setString(2, st.getFirstName());
		addStudentStmt.setString(3, st.getLastName());
		addStudentStmt.executeUpdate();
		addStudentCourses(st.getId(), st.getCourses());
	}
	
	private void addStudentCourses(String id, String courses[]) throws Exception{
		
		for (String c: courses){
			addCourseStmt.setString(1, id);
			addCourseStmt.setString(2, c);
			addCourseStmt.executeUpdate();
		}
	}

	// expected to be called only once
	String[] getCourses() throws Exception {
		String query = String.format("SELECT * FROM course ");
		ArrayList <String> alist = new ArrayList();
		Statement statement = conn.createStatement();
		resultset = statement.executeQuery(query);
		if (resultset != null) {
			while (resultset.next()) {
				String id = resultset.getString("code"); // using index
				alist.add(id);
			}
			resultset.close();
			statement.close();
			String courses [] = new String[alist.size()];
			return alist.toArray(courses);
		} else {
			throw new Exception("Cannot find courses.");
		}
	}

	void disonnect() throws Exception {
		findStudentStmt.close();
		updateStudentStmt.close();
		addStudentStmt.close();
		conn.close();
	}
	public static void main(String s[]) throws Exception {
		DataAccess da = null;
		try {
			da = new DataAccess();
			Student st = da.findStudent("200");
			System.out.println("id="+st.getId());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			if (da != null){
				da.disonnect();
			}
		}
	}
}
