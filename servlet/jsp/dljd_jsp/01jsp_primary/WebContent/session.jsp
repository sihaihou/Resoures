<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %><!-- 关闭内置对象：session -->    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 	/* 
		 * 若向session域中存放数据,则使用getSession(true),即getSession() 
		 * 若向session域中读取数据，则使用getSession(false)：有旧的session则使用旧的，没有也不创建
		 */
		HttpSession session = request.getSession(false);
		if(session != null){
			String user = (String)session.getAttribute("user");
			out.print(user);
		}
	
	%>
</body>
</html>