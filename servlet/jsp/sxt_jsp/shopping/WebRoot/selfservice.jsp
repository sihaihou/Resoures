<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="hs.mapping.bean.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
User u = (User)session.getAttribute("user");
if(u == null){
	out.print("您尚未登录！");
	return;
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'selfservice.jsp' starting page</title>
    
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
  	<form action="usermodify.jsp" method="post" onsubmit="return checkform(this);">
  	 	<input type="hidden" name="action" value="usermodify"> 
	  	 <table border="1" width="80%" height="80%"> 
	  	 	 <tr>		  	 	
	  	 		<td>个人信息</td>
		  	 </tr>
		  	 <tr>		  	 	
	  	 		<td>用户</td>
	  	 		<td> <input type="text" name="username" value="<%= u.getUsername()%>"></td>
		  	 </tr>
		  	 <tr>
		  	 	<td>密码</td>
		  	 	<td> <input type="password" name="password" value="<%= u.getPassword() %>"></td>
		  	 </tr>
			<tr>				
				<td>电话	</td>
				<td><input type="text" name="phone" value="<%= u.getPhone()%>"></td>
			</tr>
			<tr>	
				<td>地址</td>
				<td><textarea type="text" name="addr"><%= u.getAddr()%></textarea></td>
			</tr>
			<tr>				
				<td>注册时间	</td>
				<td><input type="text" name="phone" value="<%= u.getRdate()%>"></td>
			</tr>
			<tr>
				<td></td>
				<td>
				 <a href="usermodify.jsp">修改个人信息</a>
				</td>		
			</tr>		
		</table>
  </body>
</html>
