package jdbc;
import java.sql.*;

public class Insert {
	public static void main(String[] args) {
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 c = DriverManager .getConnection("jdbc:mysql://localhost:3306/emp_db","root","dbms@123");
			Statement s = c.createStatement();
			s.executeUpdate("insert into employee values(4,'Seth',47000,'Developer',079710)");
			System.out.println("Data Saved");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(c != null) {
					c.close();
				}
			}catch(SQLException e) {
			  e.printStackTrace();
		}
		
		}
	}
	
	

}


