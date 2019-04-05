<%--  声明文本格式和编码字符集：response.setContentType("text/html; charset=UTF-8"); --%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%--  引入包：import java.awt.color.*; --%>
<%@ page import="java.lang.*" %>

<%--  提供公共错误异常页面 --%>
<%@page errorPage="error.jsp" %>  
 
<%--  源码级别的导入 --%>
<%@ include file="included.jsp"  %>  

<%--  相当于类互相调用 --%>
<jsp:include page="included.jsp"></jsp:include>  

<%--  声明成员属性和方法... --%>
<%!
	int a = 3; 
	public static void test(){
		System.out.println("声明方法...");
	} 
%>

<%--  对声明属性和方法的处理 --%>
<%--  out.print(a+6)--%>
<%=a+6%>	
<%
	int b = 4;
	System.out.println(a+b);
	test();
%>

<%--   标签：在页面可以直接显示 --%>
<p>在页面直接显示</p>

<%--   java代码基本编写方式： --%>
<%
	int m = 5;
	int n = 1;
	System.out.println(m+n);
	if(m==n){
%>
	<p>m==n</p>
<%
	}else{
%>
	<p>m!=n</p>
<%
	}
%>
<% int c=1/0;%>