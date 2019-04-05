<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- EL内置对象： param获取请求中的指定值
				  paramValues获取请求中的指定所有值
				  initParam 获取全局属性值(web.xml文件)
	   -->
	${param.username }<br> 
	${param.password }<br>
	${paramValues.hobbies[0] }<br>
	${paramValues.hobbies[1] }<br>
	
	
</body>
</html>