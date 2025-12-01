package jdbc;
import java.util.Scanner;
import java.sql.*;

public class FetchByPhonePatternMatching {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter phone: ");
		long PhoneNo = input.nextLong();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","dbms@123");
			PreparedStatement ps = c.prepareStatement("select * from employee where PhoneNo like ?");
			ps.setString(1,"%"+PhoneNo+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Employee id = "+rs.getInt("Employeeid"));
				System.out.println("Employee Name= "+rs.getString("EName"));
				System.out.println("Salary= "+rs.getInt("Salary"));
				System.out.println("Job= "+rs.getString("Job"));
				System.out.println("PhoneNo= "+rs.getLong("PhoneNo"));
				System.out.println("------------------------------------------------");
				
			}
		}catch(ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}

	}

}
