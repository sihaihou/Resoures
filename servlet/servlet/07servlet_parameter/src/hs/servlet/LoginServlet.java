package hs.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  1。请求参数存放在Map中，
 *  2。这个Map的key为请求参数的名称，为String类型
 *     这歌Map的value为请求参数的所有值，为String[]类型
 *  3。使用最多的是getParameter()方法，等同于getParameterValues()[index]
 * @author 侯四海
 *
 */
public class LoginServlet extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		/**
		 * 获取指定名称的请求参数值
		 * getParameter("name")  == getParameterValues()[0]
		 */
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		System.out.println("name="+name+"   pwd="+pwd);
		
		/**
		 * 获取所有请求参数名称+参数值
		 */
		Enumeration<String> names = req.getParameterNames();
		while(names.hasMoreElements()){
			String eleName = names.nextElement();
			String eleValue = req.getParameter(eleName);
			System.out.println("eleName="+eleName+"   eleValue="+eleValue);
		}
		
		/**
		 * 获取指定参数的所有值
		 */
		String[] bobbyArr = req.getParameterValues("hobby");
		for(String str : bobbyArr){
			System.out.print("hobby:");
			System.out.println(str);
		}
		
		/**
		 *  获取请求参数的Map
		 */
		Map<String, String[]> map = req.getParameterMap();
		for(String key :map.keySet()){
			System.out.println(key+"======="+req.getParameter(key));
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
