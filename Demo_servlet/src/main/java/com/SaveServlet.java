package com;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;
@WebServlet("/save")
public class SaveServlet extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws IOException,ServletException{
		String username= req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("paswword");
		String phone = req.getParameter("phone");
		
		PrintWriter out= res.getWriter();
		
		out.print("<h1>UserName = "+username+"</h1>");
		out.print("<h1>Email = "+email+"</h1>");
		out.print("<h1>Password = "+password+"</h1>");
		out.print("<h1>PhoneNo = "+phone+"</h1>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db","root","dbms@123");
			
			PreparedStatement ps = c.prepareStatement("insert into user values(?,?,?,?)");
			
			ps.setString(1, username);
			ps.setString(2,email);
			ps.setString(3, password);
			ps.setLong(4, Long.parseLong(phone));
			
			ps.execute();
			
			out.print("<h1> Data saved</h1>");
		}catch(SQLException| ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
