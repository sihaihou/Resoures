<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>My JSP 'hubbies.jsp' starting page</title>
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
   	<form action="add.action" method="post">
   		用户：<input type="text" name="name"/><br>
   			<br>
   		爱好：<input type="checkbox" name="hubbies" value="football"/>足球
   			<input type="checkbox" name="hubbies" value="basketball"/>蓝球
   			<input type="checkbox" name="hubbies" value="pingpangball"/>乒乓球
   			<input type="checkbox" name="hubbies" value="yumaoball"/>羽毛球<br>
   			<br>
   		游戏：<input type="checkbox" name="games" value="CF"/>穿越火线
   			<input type="checkbox" name="games" value="dota"/>刀塔
   			<input type="checkbox" name="games" value="lol"/>英雄联盟<br>
   			<br>
   			<input type="submit" value="提交"/>
   	</form>
  </body>
</html>
