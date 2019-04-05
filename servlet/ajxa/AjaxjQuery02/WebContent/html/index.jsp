<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	//load()最简单、最常用ajax的方法
	$(function() {
		$("a").click(function() {
			var url = this.href;
			var args = {"time":new Date()};
			//任何一个html 节点都可以使用load方法来加载ajax，结果将直接插入到html节点中。
			$("#msg").load(url,args);
			return false;
		});
	});
</script>
</head>
<body>
  <a href="ajax.jsp">ajax jQuery html</a>
  <div id="msg"></div>
</body>
</html>