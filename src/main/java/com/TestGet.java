package com;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestGet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;

    public TestGet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public void init() throws ServletException
	{
	   // 执行必需的初始化
	}
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        // 设置响应内容类型
    	PrintWriter out = response.getWriter();
		//response.setContentType("text/json; charset=utf-8");
        response.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式  
        response.setCharacterEncoding("UTF-8");//setContentType与setCharacterEncoding的顺序不能调换，否则还是无法解决中文乱码的问题  
            
		try {  

			String jsonStr = null;
			
			// 创建 返回的Cookie      
			Cookie cooid = new Cookie("id",request.getParameter("id"));
	        Cookie cooname = new Cookie("name",URLEncoder.encode(request.getParameter("name"), "UTF-8")); // 中文转码
	        // 为两个 Cookie 设置过期日期为1分钟过期
	        cooid.setMaxAge(60*1*1); 
	        cooname.setMaxAge(60*1*1); 
	        // 在响应头中添加两个 Cookie
	        response.addCookie(cooid);
	        response.addCookie(cooname);
	        
	        // 获取请求的Cookie
 			Cookie cookie = null;
 	        Cookie[] cookies = null;
 	        if (request.getCookies() != null)
	 	        cookies = request.getCookies();
	        
 	        // 返回的其他值
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			
			//session管理
	        HttpSession session = request.getSession(true);// 如果不存在 session 会话，则创建一个 session 对象
	        Date createTime = new Date(session.getCreationTime());// 获取 session 创建时间
	        Date lastAccessTime = new Date(session.getLastAccessedTime());// 获取该网页的最后一次访问时间
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置日期输出的格式 
	        
	        //检查网页上是否有新的访问者
	        Integer visitCount = new Integer(0);
	        String visitCountKey = new String("visitCount");
	        String userIDKey = new String("userID");
	        String userID = new String("Runoob");
	        if (session.isNew()){
	             session.setAttribute(userIDKey, userID);
	        } else {
	             visitCount = (Integer)session.getAttribute(visitCountKey);
	             visitCount = visitCount + 1;
	             userID = (String)session.getAttribute(userIDKey);
	        }
	        session.setAttribute(visitCountKey,  visitCount);
	        
	        
			//for (int i = 0; i < cookies.length; i++){
			if (id.equals("DS7")) {
				jsonStr = "{\"result\":\"1\",\"message\":\"Get\","
							+ "\"data\":["
							+ "{\"id\":\"" + id + "\",\"Order\":1},"
							+ "{\"name\":\"" + name + "\",\"Order\":2},"
							+ "{\"cooid\":\"" +  cookies[1].getValue() + "\",\"Order\":3},"
							+ "{\"cooname\":\"" +  cookies[2].getValue() + "\",\"Order\":4},"
							+ "{\"count\":\"" +  visitCount + "\",\"Order\":5},"
							+ "{\"createtime\":\"" +  df.format(createTime)  + "\",\"Order\":6},"
							+ "{\"AccessTime\":\"" +  df.format(lastAccessTime)  + "\",\"Order\":7},"		
							+ "{\"address\":\"guangzhou\",\"Order\":8},"
							+ "{\"leader\":\"zhouzong\",\"Order\":9}],"
							+ "\"actions\":null,\"total\":9}";
			}
			out = response.getWriter();
			out.write(jsonStr);
			out.close();
			
			// 完成后关闭               
		}catch (Exception e) { 
			out.print("get data error!"); 
			e.printStackTrace(); 
			}
	}     
                   
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    // 处理 POST 方法请求的方法
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //doGet(request, response);
    }
}
