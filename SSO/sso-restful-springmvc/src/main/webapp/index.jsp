<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">

function add(){
	$.ajax({
		'url':'${pageContext.request.contextPath}/user',
		'type':'post',
		'data':'user={id:10,name:test}',
		'success':function(data){
			alert(data);
		}
	});
}

function modify(){
	$.ajax({
		'url':'${pageContext.request.contextPath}/user',
		'type':'put',
		'data':'user={id:1,name:guest}',
		'success':function(data){
			alert(data);
		}
	});
}

function del(){
	$.ajax({
		'url':'${pageContext.request.contextPath}/user?id=3',
		'type':'delete',
		'success':function(data){
			alert(data);
		}
	});
}

function get(){
	$.ajax({
		'url':'${pageContext.request.contextPath}/user/1',
		'type':'get',
		'success':function(data){
			alert(data);
		}
	});
}

</script>
</head>
<body>
	<center>
	
		<input type="button" value="新增" onclick="add();"/><br>
		<input type="button" value="修改" onclick="modify();"/><br>
		<input type="button" value="删除" onclick="del();"/><br>
		<input type="button" value="查询" onclick="get();"/><br>
	
	</center>
</body>
</html>