<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="hs.mapping.bean.User" %>
<%@ page import="hs.shopping.*" %>
<%@ page import="java.sql.*" %>
<%@ page import=" java.util.*" %>
<%@ include file="sessioncheck.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	List<User> list = UserManager.getUsers();
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="refresh" content="1">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
    <table border="1"  width="80%" align="center" >
   			<div align="center"><h1>用户列表</h1></div>
     		<tr>
     			<td>ID</td>
     			<td>用户名</td>
     			<td>密码</td>
     			<td>电话</td>
     			<td>家庭地址</td>
     			<td>注册时间</td>   
     			<td>操作</td> 			
     			<td>权限管理</td>    		
     			<td>删除用户</td>
     		</tr>
     		<%
     			for(Iterator<User> iter =list.iterator();iter.hasNext();){
     				User user =iter.next();				
     		 %>
     		 	<tr>
     		 		<td><a href=""><%= user.getId() %></a></td>
     		 		<td><a href=""><%= user.getUsername()%></a></td>
     		 		<td><%= user.getPassword()%></td>
     		 		<td><%= user.getPhone()%></td>
     		 		<td><%= user.getAddr()%></td>
     		 		<td><%= user.getRdate()%></td> 
     		 		<td><a href="">详情</a></td>    		 		
     		 		<td><a href="">权限</a></td>     		 		
     		 		<td><a href="userdelete.jsp?id=<%= user.getId() %>">删除</a></td>
     		 	</tr>
     		 <%  
     			  }    		
     		 %>
     		
     	</table>
     	 <h1 align="right"><a href="userlist.jsp" >返回</a></h1>
  </body>
</html>
