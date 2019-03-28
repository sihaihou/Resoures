<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="hs.mapping.bean.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
request.setCharacterEncoding("UTF-8");
String action = request.getParameter("action");
if(action != null&&action.equals("register")){
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String phone = request.getParameter("phone");
	String addr = request.getParameter("addr");		
	User user = new User(username,password,phone,addr);
	user.save();
	System.out.println(username+":\t用户注册成功！");
%>
<h1><div align="center">恭喜您!注册成功!</div></h1>
<% 
	/* out.print("恭喜!注册成功!") */;
	return;
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    <style type="text/css"></style>
    <script type="text/javascript" src="js/register.js"></script>
    
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
  	 <form action="register.jsp" method="post" onsubmit="return checkform(this);">
  	 	<input type="hidden" name="action" value="register"> 
	  	 <table border="1" width="80%" height="80%"> 
	  	 	 <tr>		  	 	
	  	 		<td>用户注册</td>
		  	 </tr>
		  	 <tr>		  	 	
	  	 		<td>用户</td>
	  	 		<td> <input type="text" name="username" id="id"></td>
		  	 </tr>
		  	 <tr>
		  	 	<td>密码</td>
		  	 	<td> <input type="password" name="password"></td>
		  	 </tr>
			<tr>				
				<td>电话	</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>	
				<td>地址</td>
				<td><textarea type="text" name="addr"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="注册">
				</td>		
			</tr>		
		</table>
	</form>
  </body>
</html>
