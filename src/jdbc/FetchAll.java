package jdbc;
import java.sql.*;

public class FetchAll {

	public static void main(String[] args) {
		
		Connection c = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","dbms@123");
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from employee");
			
			while(rs.next()) {
			System.out.println("Employee id = "+rs.getInt("Employeeid"));
			System.out.println("Employee Name= "+rs.getString("EName"));
			System.out.println("Salary= "+rs.getInt("Salary"));
			System.out.println("Job= "+rs.getString("Job"));
			System.out.println("PhoneNo= "+rs.getLong("PhoneNo"));
			System.out.println("------------------------------------------------");
			
			}


			
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
