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
	你当前是第${applicationScope.map.size()}访客 <br>
	请安全<a href="${pageContext.request.contextPath }/loginOut">退出</a><br>
	
	<c:forEach items="${map }" var="bean">
		${bean.key } == ${bean.value.size()}<br>
	</c:forEach>
</body>
</html>