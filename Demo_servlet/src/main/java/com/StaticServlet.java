package com;
import java.io.*;

import javax.servlet.*;

public class StaticServlet extends GenericServlet{
	
	@Override
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException {
		// to print on the browser
		PrintWriter out = res.getWriter();
		
		String s = "<html>"
				+"<body>"
				+"<h1> hi this static resources</h1>"
				+"</body>"
				+"</html>";
		out.print(s);
	}

}
