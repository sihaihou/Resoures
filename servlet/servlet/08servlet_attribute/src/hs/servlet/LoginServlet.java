package hs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author ���ĺ�
 *
 */
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�������з�������
		req.setAttribute("name", "hsh");
		req.setAttribute("pwd", "123456");
		
		//��������ɾ��ָ��������
		req.removeAttribute("pwd");
		
		//������ת���� OtherServlet
		req.getRequestDispatcher("/*.other").forward(req, resp);
	}
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
