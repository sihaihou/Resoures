<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	//$.get()或$.post请求
	$(function() {
		$("a").click(function() {
			var url = this.href;
			var args = {"time":new Date()};
			//url:
			//args:json格式
			//function:回调函数：当响应结束时回调函数倍触发，响应结果在data中
			$.getJSON(url,args,function(data){
				var name = data.json.name;
				var web = data.json.web;
				$("#msg").empty()
						 .append("<h2><a href='" + web + "'>" + name + "</a></h2>")
						 .append("<h2>" + web + "</h2>");
			});
			return false;
		});
	});
</script>
</head>
<body>
  <a href="ajax.js">ajax jQuery json</a>
  <div id="msg"></div>
</body>
</html>