package com;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;
@WebServlet("/demo")
public class QueryParameterDemoServlet extends GenericServlet{
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws IOException,ServletException{
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		
		PrintWriter out = res.getWriter();
		
		out.print("<h1>Id = "+ id+"</h1>");
		out.print("<h1>Name = "+ name+"</h1>");
		
		/*http:localhost:8080/Demo_Servlet/demo? id= 1 & name = tom*/
		
	}
	

}
