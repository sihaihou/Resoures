<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 当页面发生错误会自动跳转到指定页面 -->
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HTML注释会被jsp翻译引擎翻译到.java文件中  -->  
	<%-- jsp注释会被忽略掉  --%>
	
	<%
	   /* 
		* java代码块:
		*	1,内容会以java代码出现在service()方法内,
		*	2,声明的变量不能添加访问权限符
		*	3,不能定义方法
		*	4，不能定义静态语句块
		*	5，必须分号结尾
		*/
		System.out.print("java代码块");
	%>
	
	<%!
	   /*
		* java声明语句块: 
		*   1，内容会被翻译到class类中
		*	2,变量可以添加访问权限符
		*	3,可以定义方法
		*	4,可以定义静态语句块
		*/
		private int count = 4;
		public static void test(){
		
		}
	%>
	<%= count
	   /*
		* java表达式块: 
		*	结尾不能添加;结束
		*/
	%>
	
</body>
</html>