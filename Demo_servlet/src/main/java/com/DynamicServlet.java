

package com;


import java.sql.SQLException;
import java.util.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/dynamic")
public class DynamicServlet extends GenericServlet {
	@Override
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException {
		Date d = new Date();
		PrintWriter out = res.getWriter();
		 
		 String s = "<html>"
					+"<body>"
					+"<h1>"+d+"</h1>"
					+"</body>"
					+"</html>";
		 out.print(s);
		 
	}

}
