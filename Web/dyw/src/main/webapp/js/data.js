$(function(){
    getData();
})
/**
 *    菜单栏
 * <li ><a class="_self" target="_self" href="http://www.sihaihou.com">首页</a></li>
 * @returns
 */
function getData(){
	var request = new XMLHttpRequest();
    request.open("post","nav/searchList.do","true");<!--  设置请求行 -->
    request.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); <!--  设置请求头（post方式才有请求头） -->
    request.send(null);  <!--  设置请求主体 -->
    request.onreadystatechange = function(){
        if(request.readyState == 4 && request.status == 200){
            var result = request.responseText;
            var object = eval("(" + result + ")");
            var divEle = document.querySelector(".nav");
            for(var i=0;i<getJSonObjLenth(object.data.info);i++){
            	var aNode = document.createElement("a");
            	aNode.href= "http://www.sihaihou.com?id="+(i+1);
            	aNode.innerHTML = object.data.info[i];
            	var liNode = document.createElement("li");
            	liNode.appendChild(aNode);
            	divEle.appendChild(liNode);
            }
            
        }
    };
}


/**
 * 获取JSon对象的长度
 * @param jsonData
 * @returns
 */
function getJSonObjLenth(jsonObj){
	var jsonLength=0;
	for(var item in jsonObj){
		jsonLength++;
	}
	return jsonLength;
}