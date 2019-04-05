<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var jsonObject = {
		"name":"张三",
		"age":18,
		"address":{"city":"武汉","school":"武工职"},
		"teaching":function(){
			alert("JavaEE,Android");
		}
	};
	//alert(jsonObject.address.city);
	//jsonObject.teaching();
	
	
	var jsonStr = "{'name':'侯四海'}";  
	var testJson = eval("("+jsonStr+")");
	alert(testJson.name);
</script>
</head>
<body>
	
</body>
</html>