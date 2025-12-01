package jdbc;
import java.sql.*;
import java.util.Scanner;

public class FetchBySal {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter starting sal:");
		int st = input.nextInt();
		System.out.print("Enter ending sal:");
		int ed = input.nextInt();
		
		Connection c = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","dbms@123");
			
			PreparedStatement ps = c.prepareStatement("select * from employee where Salary between ? and ?");
			
			ps.setInt(1,st);
			ps.setInt(2, ed);
			
			ResultSet rs = ps.executeQuery();
			
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
			


				
		


