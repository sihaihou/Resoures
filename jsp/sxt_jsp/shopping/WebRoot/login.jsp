<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="hs.mapping.bean.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<h1><div align="center">用户登录</div></h1>  	
<%
request.setCharacterEncoding("UTF-8");
String action =request.getParameter("action");
if(action != null && action.equals("login")){
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	User u = null;
	try{
		u = User.validate(username, password);
	}catch(UserNOTFoundException e){
%>	
<h1><div align="center">用户不存在！</div></h1>
<% 
		/* out.println("用户不存在！"); */
		return;
	}catch(PasswordNOTCorrectException e){
%>	
		<h1><div align="center">密码不正确！</div></h1>
<%		
		/* out.println("密码不正确！"); */
		return;
	}
	session.setAttribute("user", u);
	System.out.println("用户："+u.getUsername()+":已登录!");
	response.sendRedirect("selfservice.jsp");	
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>  
  <body>
    <form action="login.jsp" method="post">
    	<input type="hidden" name="action" value="login">
    	用户：<input type="text" name="username" ><br>
    	密码：<input type="password" name="password"><br>
    		  <input type="submit" value="登录"><input type="reset" value="重置"><br>
    </form>
  </body>
</html>
