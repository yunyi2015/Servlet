package com;

//导入必需的 java 库
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

//扩展 HttpServlet 类
public class HelloWorld extends HttpServlet {

	private String message;
	
	public void init() throws ServletException
	{
	   // 执行必需的初始化
	   message = "Hello World 哈哈";
	}
	
	public void doGet(HttpServletRequest request,
	                  HttpServletResponse response)
	         throws ServletException, IOException
	{
	   // 设置响应内容类型
	   response.setContentType("text/html");
	
	   // 实际的逻辑是在这里
	   PrintWriter out = response.getWriter();
	   out.println("<h1>" + message + "</h1>");
	   out.println("<h2>" + message + "</h2>");
	   out.println("<h3>" + message + "</h3>");
	   out.println("<h4>" + message + "</h4>");
	   out.println("<h5>" + message + "</h5>");
	}
	
	public void destroy()
	{
	   // 什么也不做
	}
}
