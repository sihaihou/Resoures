<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="mt" uri="http://www.hs.com/jsp/tags/mytaglib"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		boolean abc = true;
		request.setAttribute("abc", abc);
	%>
	<mt:if flag="${abc }">男</mt:if>
	<mt:if flag="${!abc }">女</mt:if>
</body>
</html>