<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>My JSP 'upload.jsp' starting page</title>  
     <script src="js/jquery-3.2.1.min.js"></script>
     <script type="text/javascript">
        $(function(){
            $("#btn").click(function(){
                var field = "<p><input name='file' type='file' ><input type='button' value='删除' onclick='remove(this)'/></p>";
                $("#files").append(field);
            });
        });
        function remove(o){
            $(o).parent().remove();
        }
    </script>
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
  	<form action="batch.action" enctype="multipart/form-data" method="post">
  		文件<input type="file" name="file"/><input type="button" id="btn" value="添加"/> 
  		<div id="files"></div>  
  		<input type="submit" value="上传"/>
  	</form>
  	
  </body>
</html>
