<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="sessioncheck.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理平台</title>
    
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
    	<table border="1" width="100%" >
    		<div align="center"><h1>用户管理</h1></div>
    		<tr>
    			<td>管理</td>
    			<td><a href="userlist.jsp">用户列表</a></td>
    		</tr>
    		<tr>
    			<td>注册</td>
    			<td><a href="register.jsp">用户注册</a></td>
    		</tr>
    		<tr>
    			<td>登录</td>
    			<td><a href="login.jsp">用户登录</a></td>
    		</tr>
    	</table>
  </body>
</html>
 