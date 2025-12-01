package jdbc;
import java.sql.*;
import java.util.Scanner;

public class DeleteDynamic {
	public static void main(String[] args) {
		
	Scanner input = new Scanner(System.in);
	System.out.print("Enter employee id:");
	int Employeeid = input.nextInt();
	
	Connection c = null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","dbms@123");
		
		PreparedStatement ps = c.prepareStatement("delete from employee where Employeeid = ?");
		
		ps.setInt(1, Employeeid);
		ps.executeUpdate();
		
		System.out.println("Data Deleted");
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
