<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
        window.onload = function () {
            //1,获取 a 节点，并为其添加onclick响应函数。
            document.getElementsByTagName("a")[0].onclick = function(){
                //2,创建XMLHttpReuest 对象
                var request = new XMLHttpRequest();
                //3,准备发送请求的数据
                var url = this.href;
                //4,调用 XMLHttpRequest 对象的Open方法
                request.open("GET",url,true);
                //如果发送post请求时在这里添加：request.setRequestHeader("ContentType","application/x-www-form-urlencoded");
                //5,调用 XMLHttpRequest 对象的send方法
                request.send("name='msg'");
                //6,为 XMLHttpRequest 对象添加  onreadystatechange 响应函数，
                request.onreadystatechange = function(){
                    //7,判断响应是否完成，XMLHttpRequest对象的 readyState 属性值为 4 的时候
                    if(request.readyState == 4) {
                        //8,判断响应是否可用，XMLHttpRequest对象的 State 属性值为 200 的时候
                        if ( request.status == 200 || request.status == 304){
                            //9，打印响应结果：responseText
                            //html格式数据
                            var msg = request.responseText;
                            document.getElementById("msg").innerHTML= msg;
                         }
                    }
                }
                //10,取消 a 节点的默认行为
                return false;
            }
        }
</script>
</head>
<body>
  <a href="ajax.jsp">ajax</a>
  <div id="msg"></div>
</body>
</html>