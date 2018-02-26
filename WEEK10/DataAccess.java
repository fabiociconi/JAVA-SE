import java.sql.*;  //package for data base access

public class DataAccess {
	private Statement statement;
    private Connection conn;
	private ResultSet resultset;
    
	DataAccess() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver"); //load class 
		
		//for uid, pass, put your uid and pass
		conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD", 
								Consts.uid, Consts.pass);
		statement = conn.createStatement();
		System.out.println("Connected to JDBC");
	}
	Student findStudent(String id) throws Exception{
		String query = String.format("SELECT * FROM student WHERE sid=%s",id);	
		Student st = null;
			resultset = statement.executeQuery(query);
			if (resultset != null)
			{
				if (resultset.next())
				{
					String fname = resultset.getString(2);  //using index
					String lname = resultset.getString("last_name");  //using column name
					st = new Student(fname, lname, id);
					
				}
				resultset.close();
				return st;
			}
			else
			{
				throw new Exception("Cannot find record.");
			}
	}
	void updateStudent(Student st) throws Exception {
		String  str = String.format("UPDATE student SET student.first_name= '%s', student.last_name= '%s' WHERE student.sid=%s",
									st.getFirstName(),st.getLastName(),st.getId());
		statement.executeUpdate(str);
	}
	void addStudent(Student st) throws Exception {
		String  str = String.format("INSERT into student values ('%s', '%s', '%s')",
									 st.getId(), st.getFirstName(),st.getLastName());
		statement.executeUpdate(str);
	}
	void disonnect() throws Exception{
		statement.close();
		conn.close();
	}
}
