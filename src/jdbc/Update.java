package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) {
		
		Connection c= null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","dbms@123");
			
			Statement s = c.createStatement();
			
			s.executeUpdate
			("update employee set EName = 'Roman',Salary=17000,PhoneNo=73264773 where Employeeid = 2");
					
			
			System.out.println("Data updated");
			
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}finally {
					try{
						if(c != null) {
							c.close();
						}
					}catch(SQLException e) {
						e.printStackTrace();
					}
			}
					
	

	}

}
