<%@page contentType="text/html; charset=gbk" %>
<%@page import="hs.po.User" %>
<%
	String name=request.getParameter("name").trim();
	String pwd=request.getParameter("pwd").trim();
	if("hsh".equals(name)&&"123456".equals(pwd)){
		//登录成功
		User user = new User(name,pwd); 
		request.getSession().setAttribute("user", user);			
		//转发或 重定向
		//request.getRequestDispatcher("success.jsp").forward(request, response);
		//return;
%>
		<jsp:forward page="success.jsp"></jsp:forward>
<%
	}else {
		//登录失败
		request.setAttribute("loginError", "用户名或密码错误!");
%>
		<<jsp:forward page="login.jsp"></jsp:forward>
<%
		//request.getRequestDispatcher("login.jsp").forward(request, response);		
		//return;
	}
%>