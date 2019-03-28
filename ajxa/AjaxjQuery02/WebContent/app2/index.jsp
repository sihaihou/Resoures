<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="hs.pojo.Cart" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("a").click(function() {			
			var url = this.href;		
			var args = {"time":new Date()};	
			$.getJSON(url,args,function(data){
				$("#bookName").text(data.bookName);
				$("#totalBookNumber").text(data.totalBookNumber);
				$("#totalBookPrice").text(data.totalBookPrice);
			});
			return false;
		});
	})

</script>
</head>
<body>
	<%
		Cart cart = (Cart)session.getAttribute("sc");
		if(cart != null){
	%>
		您已经将&nbsp;<font color='red'><span id="bookName"></span>
				    </font> &nbsp;加入到购物车！<br>
	            购物车的书有 &nbsp;<font color='red'><span id="totalBookNumber"></span>
					</font>&nbsp;本！<br>
		总价格&nbsp;<font color='red'><span id="totalBookPrice"></span>
					</font>&nbsp;元<br>
	<%	
		}
	%>
	JAVA &nbsp;<a href="${pageContext.request.contextPath}/addCart?id=JAVA&price=100">加入购物车</a><br>
	AJAX &nbsp;<a href="${pageContext.request.contextPath}/addCart?id=AJAX&price=200">加入购物车</a><br>
	JAVASCRIPT &nbsp;<a href="${pageContext.request.contextPath}/addCart?id=JAVASCRIPT&price=100">加入购物车</a><br>
</body>
</html>