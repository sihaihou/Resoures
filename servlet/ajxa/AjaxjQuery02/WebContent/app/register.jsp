<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function () {
		$("[name='name']").blur(function() {
			var val = $(this).val();
			val = $.trim(val);
			if(val != ""){
				var url = "${pageContext.request.contextPath}/validateNameServlet";
				alert(url);
				var args = {"name":val,"time":new Date()};
				$.post(url,args,function(data){
					$("#msg").html(data);
				});
			}
		});
	})
</script>
</head>
<body>
	<form action="#" method="post">
		用户：<input type="text" name="name"/>
			 <span id="msg"></span><br>
		<input type="submit" name="submit"/><br>
	</form>
</body>
</html>