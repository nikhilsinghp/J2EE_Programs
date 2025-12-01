package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/login")
public class LoginServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		
		PrintWriter out = res.getWriter();
		
		if(email.equals("tom@gmail.com")) {
			if(password.equals("123")) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("home.html");
				dispatcher.forward(req, res);
			}
			else {
				out.print("<h1>Incorrect password</h1>");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
				dispatcher.include(req, res);
				
			}
		}
		else {
			out.print("<h1>Email not found</h1>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
			dispatcher.include(req, res);
			
		}
		
	}

}
