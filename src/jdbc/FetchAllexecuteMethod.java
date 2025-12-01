package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchAllexecuteMethod {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","dbms@123");
			Statement s = c.createStatement();
			boolean b = s.execute("select * from employee");
			//boolean b = s.execute("select * from employee");                                                           
			ResultSet rs = s.getResultSet();
			
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


	
