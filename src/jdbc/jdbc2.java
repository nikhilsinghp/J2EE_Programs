package jdbc;

import java.sql.*;

public class jdbc2 {

	public static void main(String[] args) {
		
		try {
			
			//1. load or register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. establish connection
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","dbms@123");
			
			//3. Create Connection
			Statement s = c.createStatement();
			
			//4. Execute Query
			s.executeUpdate("insert into employee values(1,'Allen',15000,'Developer',32436343)");
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}

