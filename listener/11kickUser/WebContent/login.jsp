<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hs.pojo.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/loginServlet" method="post">
		<label for="name">用户名</label>
		<input type="text" name="name" id="name"><br>
		<label for="pwd">用户名</label>
		<input type="password" name="pwd" id="pwd"><br>
		<input type="submit" value="登录" />
	</form>
</body>
</html>