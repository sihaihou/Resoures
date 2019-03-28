<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
	生日格式：2001-01-01
	
	<s:actionerror/>
	<s:fielderror></s:fielderror>
	<form action="register.action" method="post">
		用户：<input type="text" name="name" /><br> 
		密码：<input type="text" name="pwd" /><br> 
		年龄：<input type="text" name="age" /><br>
		生日：<input type="text" name="birthday" /><br> 
		      <input type="submit" value="提交"><br>
	</form>
</body>
</html>
