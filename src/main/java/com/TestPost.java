package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestPost extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
      
    public TestPost() {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        // 设置响应内容类型
    	PrintWriter out = response.getWriter();
		//response.setContentType("text/json; charset=utf-8");
        response.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式  
        response.setCharacterEncoding("UTF-8");//setContentType与setCharacterEncoding的顺序不能调换，否则还是无法解决中文乱码的问题  
            
		try {  
//			JSONArray jsonarray = new JSONArray();  
//			JSONObject jsonobj = new JSONObject(); 
			String jsonStr = null;
			
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			
			//String jsonStr = "{\"id\":\"123\",\"name\":\"小黎\"}";   
			
			if (id.equals("DS7")) {
				jsonStr = "{\"result\":\"1\",\"message\":\"post\","
							+ "\"data\":["
							+ "{\"id\":\"" + id + "\",\"Order\":1}],"
							+ "\"actions\":null,\"total\":1}";
			}
			
			out = response.getWriter() ;  
			out.write(jsonStr);  
			out.close();  
			
			// 输出数据
//			out = response.getWriter();
//			out.println(jsonarray);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //doPost(request, response);
    }
}
