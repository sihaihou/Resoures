package hs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author Administrator
 *
 */
public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//��Ӧ��������Ľ��������  text/html��MIME����
		resp.setContentType("text/html;charset=utf-8");
		//�����޸ġ�ָ��MIME���ַ����룬����Ӧ��ı���
		//resp.setCharacterEncoding("utf-8");
		
		
		//��ȡ��־�����
		PrintWriter out = resp.getWriter();
		//���־�����д�����ݣ���ô�ͻ���������ͻῴ����Щ����
		//���������ʽ��
		/*out.append("This is append...");
		out.println("This is println...");
		out.print("This is print...");*/
		//����Ӧ��������Զ�����رա����Բ����������
		/*out.close();*/
			
		String name = (String) req.getParameter("name");
		String pwd = (String) req.getParameter("pwd");
		//���ݴ�ӡ������̨
		System.out.println("name="+name);
		System.out.println("pwd="+pwd);
		//������Ӧ���ͻ�������� 
		out.append("name="+name);
		out.print("pwd="+pwd);	
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}
