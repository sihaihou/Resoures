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
	%>
	<%	
		List<Student> list = Arrays.asList(s1,s2,s3);
		request.setAttribute("list", list);
	%>
	----List-----<br>
	<mt:forEach items="${list }" var="bean">
		${bean.name} ------- ${bean.age}  <br>
	</mt:forEach>
	
	<%
		Set<Student> set = new HashSet<Student>();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		request.setAttribute("set", set);
	%>
	----set-----<br>
	<mt:forEach items="${set }" var="bean">
		${bean.name} ------- ${bean.age}  <br>
	</mt:forEach>
	
	<%
		Map<String,Student> map = new HashMap<String,Student>();
		map.put("s1",s1);
		map.put("s2",s2);
		map.put("s3",s3);
		request.setAttribute("map", map);
	%>
	----Map-----<br>
	<mt:forEach items="${map }" var="bean">
		${bean.key} ------- ${bean.value.name}---${bean.value.age}  <br>
	</mt:forEach>
	
	<%
		Object[] obj = {s1,s2,s3};
		request.setAttribute("obj", obj);
	%>
	----Object[]-----<br>
	<mt:forEach items="${obj }" var="bean">
		${bean.name} ------- ${bean.age}  <br>
	</mt:forEach>
	
	<%
		int[] num = {1,2,3};
		request.setAttribute("num", num);
	%>
	----int[]-----<br>
	<mt:forEach items="${num }" var="bean">
		${bean}  <br>
	</mt:forEach>
		
</body>
</html>