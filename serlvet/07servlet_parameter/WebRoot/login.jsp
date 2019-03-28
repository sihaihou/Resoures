<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
   	<form action="login.login" method="post">
   		用户名：<input type="text" name="name"/><br>
   		密码<input type="password" name="pwd"/><br>
   		爱好：<br>
   			<input type="checkbox" name="hobby" value="swimming"/>游泳
   			<input type="checkbox" name="hobby" value="reading"/>阅读
   			<input type="checkbox" name="hobby" value="running"/>跑步
   			<input type="submit" value="login"/>
   	</form>
  </body>
</html>
