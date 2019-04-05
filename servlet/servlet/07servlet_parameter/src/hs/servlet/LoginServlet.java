package hs.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  1��������������Map�У�
 *  2�����Map��keyΪ������������ƣ�ΪString����
 *     ���Map��valueΪ�������������ֵ��ΪString[]����
 *  3��ʹ��������getParameter()��������ͬ��getParameterValues()[index]
 * @author ���ĺ�
 *
 */
public class LoginServlet extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		/**
		 * ��ȡָ�����Ƶ��������ֵ
		 * getParameter("name")  == getParameterValues()[0]
		 */
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		System.out.println("name="+name+"   pwd="+pwd);
		
		/**
		 * ��ȡ���������������+����ֵ
		 */
		Enumeration<String> names = req.getParameterNames();
		while(names.hasMoreElements()){
			String eleName = names.nextElement();
			String eleValue = req.getParameter(eleName);
			System.out.println("eleName="+eleName+"   eleValue="+eleValue);
		}
		
		/**
		 * ��ȡָ������������ֵ
		 */
		String[] bobbyArr = req.getParameterValues("hobby");
		for(String str : bobbyArr){
			System.out.print("hobby:");
			System.out.println(str);
		}
		
		/**
		 *  ��ȡ���������Map
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
