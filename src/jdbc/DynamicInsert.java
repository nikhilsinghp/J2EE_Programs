package jdbc;
import java.sql.*;
import java.util.Scanner;



public class DynamicInsert {

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
		
		Connection c = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","dbms@123");
			PreparedStatement ps = c.prepareStatement("insert into employee values(?,?,?,?,?)");
			
			ps.setInt(1, Employeeid);
			ps.setString(2, EName);
			ps.setInt(3, Salary);
			ps.setString(4, Job);
			ps.setLong(5, PhoneNo);
			
			ps.executeUpdate();
			
			System.out.println("Data inserted");
			
			
			
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
