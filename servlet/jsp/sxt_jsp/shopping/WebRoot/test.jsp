<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="hs.mapping.bean.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<h1><div align="center">管理平台</div></h1>  	
<h1><div ></div></h1>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>管理平台</title>
</head>
<body>
	<ul><h3>用户管理</h3>
	<ul><a href="login.jsp">用户登录</a></ul>
	<ul><a href="register.jsp">用户注册</a></ul>
	<ul><a href="userlist.jsp">用户列表</a></ul>
	<a><h3>管理员</h3></a><ul>
	<a href="userlogin.jsp">管理登录</a><br>
	<a href="userlist2.jsp">删除用户</a>
</body>
</html>