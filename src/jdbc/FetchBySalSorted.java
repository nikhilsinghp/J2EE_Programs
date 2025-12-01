package jdbc;
import java.sql.*;

public class FetchBySalSorted {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","dbms@123");
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from employee order by Salary desc");
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
		}

	}

}
