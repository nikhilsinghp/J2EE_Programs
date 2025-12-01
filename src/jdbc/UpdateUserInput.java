package jdbc;

import java.sql.*;
import java.util.Scanner;

public class UpdateUserInput {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter id:");
		int Employeeid = input.nextInt();
		
		System.out.print("Enter salary:");
		int Salary = input.nextInt();
		
		System.out.print("Enter phone:");
		long PhoneNo = input.nextLong();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","dbms@123");
			
			PreparedStatement ps = c.prepareStatement("update employee set Salary = ?,PhoneNo=? where Employeeid=?");
			ps.setInt(1, Salary);
			ps.setLong(2, PhoneNo);
			ps.setInt(3, Employeeid);
			
			ps.executeUpdate();
			
			System.out.println("Data updated");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	 

	}

}
