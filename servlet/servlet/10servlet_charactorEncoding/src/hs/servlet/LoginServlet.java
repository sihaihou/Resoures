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
 *  解决请求中文乱码
 * @author Administrator
 *
 */
public class LoginServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {

		/**
		 * 解决POST提交时的中文乱码问题，无法解决GET提交请求时的中文乱码问题。
		 * setCharacterEncoding()方法设置了'请求正文'中的字符编码。
		 */
		// req.setCharacterEncoding("UTF-8");

		/**
		 * 对于请求中的中文乱码解决方法 (仅支持tomcat服务器没解决get方式的中文乱码。)
		 */
		// 这里接收到的name，其字符编码为ISO8859-1
		String name = req.getParameter("name");
		
		// 打散：将name字符串按照原源码进行打散
		byte[] bytes = name.getBytes("ISO8859-1");
		// 组装：将bytes字节数组按照指定字符编码进行组装为String。
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
