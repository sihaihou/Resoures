<%@page contentType="text/html; charset=gbk" %>
<%@page import="hs.po.User" %>
<%
	String name=request.getParameter("name").trim();
	String pwd=request.getParameter("pwd").trim();
	if("hsh".equals(name)&&"123456".equals(pwd)){
		//��¼�ɹ�
		User user = new User(name,pwd); 
		request.getSession().setAttribute("user", user);			
		//ת���� �ض���
		//request.getRequestDispatcher("success.jsp").forward(request, response);
		//return;
%>
		<jsp:forward page="success.jsp"></jsp:forward>
<%
	}else {
		//��¼ʧ��
		request.setAttribute("loginError", "�û������������!");
%>
		<<jsp:forward page="login.jsp"></jsp:forward>
<%
		//request.getRequestDispatcher("login.jsp").forward(request, response);		
		//return;
	}
%>