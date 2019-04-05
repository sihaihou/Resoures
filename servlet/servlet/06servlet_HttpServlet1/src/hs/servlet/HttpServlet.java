package hs.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 自定义HttpServlet
 * @author 侯四海
 *
 */
public class HttpServlet extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		HttpServletRequest requset = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		//获取请求方法名:单独提出来作为一个方法
		/*String method = requset.getMethod();
		//System.out.println("method="+method);
		 * 根据请求名做不同的处理
		if("POST".equals(method)){
			doPost(requset,response);
		}else if("GET".equals(method)){
				doGet(requset,response);
			}*/
		//获取请求方法名
		service(requset,response);						
	}
	public void service(HttpServletRequest requset,HttpServletResponse response){
		//获取请求方法名
		String method = requset.getMethod();
		if("POST".equals(method)){
			doPost(requset,response);
		}else if("GET".equals(method)){
				doGet(requset,response);
			}
	}
	
	
	//空方法，让子类重写
	protected void doPost(HttpServletRequest requset, HttpServletResponse response) {
		
	}
	protected void doGet(HttpServletRequest requset, HttpServletResponse response) {
		
	}
}
