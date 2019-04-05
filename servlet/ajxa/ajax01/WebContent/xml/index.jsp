<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
        window.onload = function () {
            document.getElementsByTagName("a")[0].onclick = function(){
                var request = new XMLHttpRequest();
                var url = this.href;
                request.open("GET",url,true);               
                request.send(null);
                request.onreadystatechange = function(){
                    if(request.readyState == 4) {
                        if ( request.status == 200 || request.status == 304){
                            //1,xml格式数据  resposeXML
                           var result = request.responseXML;
                            //2,结果不能直接使用，必须先创建对应的节点，再把节点加入到  #msg 中
                           /*
                           		<h1><a href="www.baidu.com">Ajax Xml百度一下</a></h1>
                           */ 
                            var name = result.getElementsByTagName("name")[0].firstChild.nodeValue;
                            var web = result.getElementsByTagName("web")[0].firstChild.nodeValue;
                            
                            var aNode = document.createElement("a");
                            aNode.appendChild(document.createTextNode(name));
                            aNode.href = web;
                            var h1Node = document.createElement("h1");
                            h1Node.appendChild(aNode);
                            
                            var msg = document.getElementById("msg");
                            msg.innerHTML="";
                            msg.appendChild(h1Node);
                         }
                    }
                }
                return false;
            }
        }
</script>
</head>
<body>
  <a href="ajax.xml">ajax xml</a>
  <div id="msg"></div>
</body>
</html>