package hs.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �̳��Զ���HttpServlet
 * @author ���ĺ�
 *
 */
public class LoginServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest requset, HttpServletResponse response) {
		System.out.println("=======doPost========");
	}
	@Override
	public void doGet(HttpServletRequest requset, HttpServletResponse response) {
		System.out.println("=======doPost========");
	}
}
