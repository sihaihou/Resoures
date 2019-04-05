package hs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/some")
public class SomeCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//创建两个cookie
		Cookie cookie1 = new Cookie("username","zhangsan");
		//Cookie cookie2 = new Cookie("userage","18");
	/*	
		//指定cookie绑定的路径，这里的路径必须指定项目名称
		cookie1.setPath(request.getContextPath()+"/username/cookie");
		cookie2.setPath(request.getContextPath()+"/userage/cookie");
		
		//设置cookie的有效期，这个值为一个整形数，单位 秒
		//改值大于零，表示将cookie写入到硬盘
		//改值小于零，表示将cookie写入到缓存
		cookie1.setMaxAge(60 * 60);   	//设置cookie的有效期为一小时
		cookie2.setMaxAge(60 * 60 * 24);  //设置cookie的有效期为一天
	 */		
		//向响应中添加cookie
		response.addCookie(cookie1);
		//response.addCookie(cookie2);
	}

}
