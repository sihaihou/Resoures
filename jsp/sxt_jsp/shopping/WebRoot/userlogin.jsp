<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="hs.mapping.bean.*" %>
<%@ page import="hs.shopping.*" %>
<%@ page import="java.sql.*" %>
<%@ page import=" java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<h1><div align="center">管理员登录</div></h1>  	
<%
String action = request.getParameter("action");
if(action!=null&&action.equals("userlogin")){
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	if(username==null||!username.equals("admin")){
	/* out.print("用户名不存在"); */
%>			
		<h1>用户名不存在</h1>
<%
	}else if(password==null||!password.equals("admin")){
		/* out.print("密码不正确"); */
%>		
		<h1>密码不正确</h1>
<%		
	}else{
		session.setAttribute("admin",username);
		response.sendRedirect("admin.jsp");
	}
}
%>
<%
	System.out.println("管理员 admin:已登录！");
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
    <form action="userlogin.jsp" method="post">
    	<input type="hidden" name="action" value="userlogin">
    	用户：<input type="text" name="username"><br>
    	密码：<input type="password" name="password"><br>
    		  <input type="submit" value="登录"><input type="reset" value="重置"><br>
    </form>
  </body>
</html>
