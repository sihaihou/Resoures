<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>My JSP 'download.jsp' starting page</title>   
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
  		<!-- <video width="700px" height="540px" controls="controls" >
	        <source src="download/周星驰功夫-只要为你活一天.mp4" type="video/mp4">
	    </video> -->
    	<h2>周星驰功夫-只要为你活一天   <a href="streamdownload.action?fileName=周星驰功夫-只要为你活一天.mp4">下载</a></h2><br>
    	<h2>别爱我.mp4<a href="streamdownload.action?fileName=别爱我.m4a">下载</a></h2><br>
  </body>
</html>
