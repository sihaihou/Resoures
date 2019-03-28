<%@page contentType="text/html; charset=gbk" %>
<%@page import="hs.po.User" %>
<html>
	<head>
		<title></title>
	</head>
	<body>
		<h1><%=request.getAttribute("loginError")==null?"":request.getAttribute("loginError") %></h1>
		<form name="regFrm" action="handleLogin.jsp" method="post">
			ำรปงฃบ<input type="text" name="name"><br>
			รÜย๋ฃบ<input type="password" name="pwd"><br>
				<input type="submit" value="submit"><br>
		</form>
	</body>
</html>