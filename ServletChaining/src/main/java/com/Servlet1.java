package com;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.sql.*;

@WebServlet("/s1")
public class Servlet1 extends GenericServlet{
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws IOException,ServletException{
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("s2");
		dispatcher.forward(req, res);
	}

}
