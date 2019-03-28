<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>My JSP 'index.jsp' starting page</title>
    <style type="text/css">
    	table.td{
    		text-align:center; 
    	}
    </style>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>  
  <body>
     	<table border="1"  width="80%" align="center" >
     		<tr>
     			<td>订单号</td>
     			<td>桌号</td>
     			<td>价格</td>
     			<td>操作</td>
     		</tr>
     		<c:forEach items="${list }" var="bean">
     			<tr>
     				<td>${bean.id}</td>
     				<td>${bean.deskId}</td>
     				<td>${bean.totalPrice}</td>
     				<td><a href="detail.action?orderId=${bean.id}">详情</a></td>
     			</tr>
     		</c:forEach>
     	</table>
  </body>
</html>