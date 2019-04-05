<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hs.pojo.*,java.util.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- EL表达式只能从四大域中获取数据,顺序由小到大  -->
	<% 	
		pageContext.setAttribute("username", "zhangsan");
		request.setAttribute("username", "lisi");
		session.setAttribute("username", "wangwu");
		application.setAttribute("username", "zhanoliu");
	%>
	${requestScope.username }   <br>
	
	<!-- EL访问对象 -->
	<%
		Student stu = new Student("hsh",18);
		request.setAttribute("stu", stu);
	%>
	EL访问对象<br>
	${stu.name }      <br>
	${stu.age }       <br>
	${stu['name'] }   <br>
	${stu['age'] }    <br>
	
	<!-- EL访问数组  -->
	<%
		String[] str = {"aaa","bbb","ccc"};
		request.setAttribute("str", str);
	%>
	EL访问数组 <br>
	${str[0] }   <br>
	${str[1] }   <br>
	${str[2] }   <br>
	
	<!-- EL访问List:无法访问set  -->
	<%
		List list = Arrays.asList("aaa","bbb","ccc");
	request.setAttribute("list", list);
	%>
	EL访问List<br>
	${list[0] }   <br>
	${list[1] }   <br>
	${list[2] }   <br>
	
	<!-- EL访问Map -->
	<%
		Map<String,Student> map = new HashMap<String,Student>();
		map.put("aaa",new Student("zs",18));
		map.put("bbb",new Student("ls",20));
		map.put("ccc",new Student("ww",21));
		request.setAttribute("map", map);
	%>
	EL访问Map<br>
	${map.aaa.name }   <br>
	${map.bbb.age }    <br>
	${map.ccc.name }   <br>
	
	<!-- EL的内置对象一：pageContext:用的最多的地方,路径访问 -->
	<form action="${pageContext.request.contextPath}/success.jsp">
		<input type="text" name="username"/><br> 
		<input type="password" name="password"/><br>
		<input type="checkbox" name="hobbies" value="swimming"/>
		<input type="checkbox" name="hobbies" value="running"/> 
		<input type="submit" value="submit"/><br> 
	</form>
	
</body>
</html>