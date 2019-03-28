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
		//��������cookie
		Cookie cookie1 = new Cookie("username","zhangsan");
		//Cookie cookie2 = new Cookie("userage","18");
	/*	
		//ָ��cookie�󶨵�·���������·������ָ����Ŀ����
		cookie1.setPath(request.getContextPath()+"/username/cookie");
		cookie2.setPath(request.getContextPath()+"/userage/cookie");
		
		//����cookie����Ч�ڣ����ֵΪһ������������λ ��
		//��ֵ�����㣬��ʾ��cookieд�뵽Ӳ��
		//��ֵС���㣬��ʾ��cookieд�뵽����
		cookie1.setMaxAge(60 * 60);   	//����cookie����Ч��ΪһСʱ
		cookie2.setMaxAge(60 * 60 * 24);  //����cookie����Ч��Ϊһ��
	 */		
		//����Ӧ�����cookie
		response.addCookie(cookie1);
		//response.addCookie(cookie2);
	}

}
