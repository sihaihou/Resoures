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
${applicationScope.map.key }
	<table border="1">
		<caption>已登录用户</caption>
		<thead>
			<tr>
				<th>用户名</th>
				<th>session</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${map }" var="entry">
				<tr>
					<td>${entry.key }</td>
					<td>${entry.value }</td>
					<td><a href="${pageContext.request.contextPath }/kickServlet?name=${entry.key}">剔除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>