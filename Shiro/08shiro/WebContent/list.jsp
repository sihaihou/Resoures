<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	list<a href="logout">退出</a>
	<%
	String username = (String) session.getAttribute("crruentUser");
	%>
	用户:<%=username %>
	 <shiro:hasPermission name="role:add">
		 <a href="">添加</a>
	 </shiro:hasPermission>
	 <shiro:hasPermission name="role:delete">
		 <a href="">删除</a>
	 </shiro:hasPermission>
	 <shiro:hasPermission name="role:update">
		 <a href="">编辑</a>
	 </shiro:hasPermission>
	 <shiro:hasPermission name="role:list">
		 <a href="">查询</a>
	 </shiro:hasPermission>
</body>
</html>