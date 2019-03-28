package hs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author Administrator
 *
 */
public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//响应中文乱码的解决方法：  text/html是MIME类型
		resp.setContentType("text/html;charset=utf-8");
		//用于修改、指定MIME的字符编码，即响应体的编码
		//resp.setCharacterEncoding("utf-8");
		
		
		//获取标志输出流
		PrintWriter out = resp.getWriter();
		//向标志输出流写入数据，那么客户端浏览器就会看到这些数据
		//三种输出方式：
		/*out.append("This is append...");
		out.println("This is println...");
		out.print("This is print...");*/
		//在响应结束后会自动对齐关闭。所以不对其操作。
		/*out.close();*/
			
		String name = (String) req.getParameter("name");
		String pwd = (String) req.getParameter("pwd");
		//数据打印到控制台
		System.out.println("name="+name);
		System.out.println("pwd="+pwd);
		//数据响应到客户端浏览器 
		out.append("name="+name);
		out.print("pwd="+pwd);	
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}
