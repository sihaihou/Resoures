package hs.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *  ���������������
 * @author Administrator
 *
 */
public class LoginServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {

		/**
		 * ���POST�ύʱ�������������⣬�޷����GET�ύ����ʱ�������������⡣
		 * setCharacterEncoding()����������'��������'�е��ַ����롣
		 */
		// req.setCharacterEncoding("UTF-8");

		/**
		 * ���������е��������������� (��֧��tomcat������û���get��ʽ���������롣)
		 */
		// ������յ���name�����ַ�����ΪISO8859-1
		String name = req.getParameter("name");
		
		// ��ɢ����name�ַ�������ԭԴ����д�ɢ
		byte[] bytes = name.getBytes("ISO8859-1");
		// ��װ����bytes�ֽ����鰴��ָ���ַ����������װΪString��
		name = new String(bytes, "utf-8");

		String pwd = req.getParameter("pwd");
		System.out.println("name=" + name);
		System.out.println("pwd=" + pwd);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
