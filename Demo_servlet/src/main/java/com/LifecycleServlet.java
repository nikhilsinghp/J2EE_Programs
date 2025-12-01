package com;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.util.*;
import java.io.*;
import java.sql.SQLException;

@WebServlet("/life")
public class LifecycleServlet extends GenericServlet{
	@Override
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException {
		System.out.println("this is service method");
	}
	
	@Override
	public void init() {
		System.out.println("hi this is init method");
	}
	
	@Override
	public void destroy() {
		System.out.println("hi this is destroy method");
	}


}
	
	


