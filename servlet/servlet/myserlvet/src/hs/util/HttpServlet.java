package hs.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �Զ��� HttpServlet
 * @author ���ĺ�
 *
 */
public class HttpServlet extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException {
		HttpServletRequest requset = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		//��ȡ���󷽷���
		service(requset,response);						
	}
	public void service(HttpServletRequest requset,HttpServletResponse response)
			throws ServletException, IOException{
		//��ȡ���󷽷���
		String method = requset.getMethod();
		if("POST".equals(method)){
			doPost(requset,response);
		}else if("GET".equals(method)){
				doGet(requset,response);
			}
	}
	
	
	//�շ�������������д
	public void doPost(HttpServletRequest requset, HttpServletResponse response)  
			throws ServletException, IOException{
		
	}
	public void doGet(HttpServletRequest requset, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}
}
