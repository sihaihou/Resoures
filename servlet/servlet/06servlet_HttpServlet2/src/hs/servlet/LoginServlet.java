package hs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �̳�API�ṩ��HttpServlet��
 * @author ���ĺ�
 *
 */
public class LoginServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest requset, HttpServletResponse response) {
		System.out.println("=======doPost========");
	}
	
	
	//���ø÷�����POST/GET���󶼿���
	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}*/
}
