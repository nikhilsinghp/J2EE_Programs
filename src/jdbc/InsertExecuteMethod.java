package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertExecuteMethod {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Employeeid");
		int Employeeid = input.nextInt();
		System.out.print("Enter employee name");
		String EName = input.next();
		System.out.print("enter salary");
		int Salary = input.nextInt();
		System.out.print("Enter job");
		String Job = input.next();
		System.out.print("Enter phone ");
		long PhoneNo = input.nextLong();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","dbms@123");
			PreparedStatement ps = c.prepareStatement("insert into employee values(?,?,?,?,?)");
			
			ps.setInt(1, Employeeid);
			ps.setString(2, EName);
			ps.setInt(3, Salary);
			ps.setString(4, Job);
			ps.setLong(5, PhoneNo);
			
			ps.execute();
			
			System.out.println("Data inserted");
			
			
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

	}

}


	
