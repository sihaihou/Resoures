<%@page contentType="text/html; charset=gbk" %>
<%@page import="hs.po.User" %>
<html>
	<head>
		<title></title>
	</head>
	<body>
		<h1>»¶Ó­µÇÂ½£¬<%=((User)session.getAttribute("user")).getName() %></h1>
		<a href="exit.jsp">ÍË³ö</a>
	</body>
</html>