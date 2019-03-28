<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %><!--  ognl表达式标签库 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  	
  <body>			<%-- <s:property value="name"/>
  						 <s:property value="#session.user"/> ognl表达式
  						 ValueStact相当于小数据，ActionContext相当于大数据
  						 value="name":直接从ValueStact中取
  						  value="#session.user"：从ActionContext中取
  					--%>
   		<h1><div align="center"><s:property value="name"/>登录成功</div></h1>
   		<h1><div align="center"><s:property value="#session.user"/>登录成功</div></h1>
  </body>
</html>
