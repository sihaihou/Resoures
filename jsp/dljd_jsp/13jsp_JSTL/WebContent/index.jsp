<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.hs.pojo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	
		Student s = new Student();
		Student s1 = new Student("aaa",18);
		Student s2 = new Student("bbb",20);
		Student s3 = new Student("ccc",21);
	%>
	
	--- 将变量存放到指定域中--- <br>
	<c:set var="name" value="zhangsan" scope="session"/>
	name  = ${name }<br>
	
	---为bean的属性赋值---<br>	
	<%
		request.setAttribute("s", s);
	%>
	<c:set value="zs" property="name" target="${s }"></c:set>
	<c:set value="18" property="age" target="${s }"></c:set>
	${s }<br>
	
	---为Map赋值---<br>	
	<%
		Map<String,Object> map = new HashMap<String,Object>();
		request.setAttribute("map", map);
	%>
	<c:set value="zs" property="name" target="${map }"></c:set>
	<c:set value="18" property="obj" target="${map }"></c:set>
	${map }---${map.name }--${map.obj } <br>	
	
	---删除指定域中的属性--<br>
	<c:set var="name" value="zhangsan" scope="session"/>
	<c:remove var="name" scope="session"/>
	name ===${name }<br>	
	---删除所有域中的属性--<br>
	<c:set var="name" value="request_zhangsan" scope="request"/>
	<c:set var="name" value="session_zhangsan" scope="session"/>
	<c:remove var="name"/>
	name ===${name }<br>	
	
	---c:catch捕获异常---<br>
	<c:catch var="e">
		<%
			int i = 2/0;
		%>
	</c:catch>
	e==${e.message }
</body>
</html>