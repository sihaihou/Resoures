<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	//load()最简单、最常用ajax的方法
	$(function() {
		$("a").click(function() {
			var url = this.href;
			$("#msg").load(url);
			return false;
		});
	});
</script>
</head>
<body>
  <a href="ajax.txt">ajax jQuery test</a>
  <div id="msg"></div>
</body>
</html>