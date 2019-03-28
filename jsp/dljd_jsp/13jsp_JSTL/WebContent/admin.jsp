<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	---c:if---<br>
	<%
		String user =  "admin";
		session.setAttribute("user", user);
	%>
	<c:if test="${user == 'admin' }">
		<a href="">进入</a><br>
	</c:if>
	
	---c:choose---<br>
	<%
		int pageNo = 6;
		int totalPage = 6;
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("totalPage", totalPage);
	%>
	<c:choose>
		<c:when test="${totalPage == 1}">
			首页&nbsp;&nbsp;上一页&nbsp;&nbsp; 下一页&nbsp;&nbsp;  末页&nbsp;&nbsp;    ${pageNo }/${totalPage }
		</c:when>
		<c:when test="${pageNo == 1}">
			首页 &nbsp;&nbsp;上一页&nbsp;&nbsp; <a href="#">下一页</a>&nbsp;&nbsp;<a href="#">末页</a>&nbsp;&nbsp;${pageNo }/${totalPage }
		</c:when>
		<c:when test="${pageNo == totalPage}">
			<a href="">首页</a>&nbsp;&nbsp;<a href="">上一页</a>&nbsp;&nbsp;下一页  &nbsp;&nbsp;末页    &nbsp;&nbsp;${pageNo }/${totalPage }
		</c:when>
		<c:otherwise>
			<a href="">首页</a>&nbsp;&nbsp;<a href="">上一页</a>&nbsp;&nbsp;<a href="#">下一页</a>&nbsp;&nbsp;<a href="#">末页</a>&nbsp;&nbsp;${pageNo }/${totalPage }
		</c:otherwise>
	</c:choose>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>