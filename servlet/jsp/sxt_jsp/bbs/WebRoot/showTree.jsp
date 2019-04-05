<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
	Statement ps = conn.createStatement();
	ResultSet rs = ps.executeQuery("select * from bbs");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showTree.jsp' starting page</title>
    
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
    <table border="1" width="100%" height="100%">
    	<%
    		while(rs.next()){
    	%>
    	<tr>
    		<td>
    			<%="<a href='show.jsp?id="+rs.getObject("id")+"'>"+rs.getInt("id")+"</a>"%>
    		</td>
    		<td>
    			<%="<a href='show.jsp?id="+rs.getObject("id")+"'>"+rs.getString("title")+"</a>"%>
    		</td>
    		<td>
    			<%="<a href='show.jsp?id="+rs.getObject("id")+"'>"+rs.getString("cont")+"</a>"%>
    		</td>
    		<td>
    			<%="<a href='show.jsp?id="+rs.getObject("id")+"'>"+rs.getDate("pdate")+"</a>"%>
    		</td>
    	</tr>
    	<%
    		}
    	 %>
  </body>
 <%
 	rs.close();
	ps.close();
	conn.close();
 %>
</html>
