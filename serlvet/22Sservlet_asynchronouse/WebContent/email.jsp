<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Integer sum = (Integer)session.getAttribute("sum");
		if(sum == 55){
			out.print("注册成功");
		}else{
			out.print("注册失败,请重新注册！");
		}
	%>
</body>
</html>