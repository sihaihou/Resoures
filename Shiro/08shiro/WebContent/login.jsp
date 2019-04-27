<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		<input type="text" name="name" placeholder="用户名"/><br>
		<input type="text" name="pwd" placeholder="密码"/><br>
		<input type="checkbox" name="rememberMe"/><p>记住我</p><br>
		<input type="submit" value="login"/>
	</form>
</body>
</html>