package hs.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class validateNameServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html,charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		List<String> list = Arrays.asList("aaa","bbb","ccc");
		String name = request.getParameter("name");
		String result = "";
		if(list.contains(name)) {
			result = "<font color='red'>�û����Ѿ���ʹ��</font>";
		}else{
			result = "<font color='green'>�û�������ʹ��</font>";
		}
		response.getWriter().println(result);
	}
}
