<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.hs.pojo.*"%>    
<%@ taglib prefix="mt" uri="http://www.hs.com/jsp/tags/mytaglib"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	
		Student s1 = new Student("aaa",18);
		Student s2 = new Student("bbb",20);
		Student s3 = new Student("ccc",21);
		List<Student> list = Arrays.asList(s1,s2,s3);
		request.setAttribute("list", list);
	%>
	<mt:forEachList items="${list }" var="bean">
		${bean.name} ------- ${bean.age}  <br>
	</mt:forEachList>
</body>
</html>