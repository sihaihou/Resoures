package hs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 继承API提供的HttpServlet类
 * @author 侯四海
 *
 */
public class LoginServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest requset, HttpServletResponse response) {
		System.out.println("=======doPost========");
	}
	
	
	//启用该方法：POST/GET请求都可以
	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}*/
}
