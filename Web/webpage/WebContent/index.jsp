<%@page import="hs.dao.impl.HtmlDaoImpl"%>
<%@page import="hs.service.impl.HtmlServicImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>           
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%!
public static List getName(String name,HttpServletRequest request){
	List<String> list = new ArrayList<String>();
	String path = request.getRealPath(name);
	File file =new File(path);
	if( file == null || !file.exists() ){
		return null;
	}
	if(file.isDirectory()){
		for(File temp:file.listFiles()){
				list.add(temp.getName());			
		}   		
	}
	return list;
}
%>
<%	// 从数据库取出 每一个学科对象：( 如：css、html、jQuery、javajscript) 并放入list容器中.
	List parsonList = new ArrayList();
	HtmlServicImpl htmlServiceImpl = new HtmlServicImpl();
	htmlServiceImpl.setHtmlDao(new HtmlDaoImpl());
	for(int i=0;i < htmlServiceImpl.getHtml().size();i++){
		parsonList.add(htmlServiceImpl.getHtml().get(i).getName());
	}
	
	// 模拟数据库：从list容器中取出 每一个学科对象：( 如：css、html、jQuery、javajscript) 并放入list容器中.
	//List parsonList = new ArrayList();
	/* List list = Arrays.asList("css","html","jQuery","javajscript","bootstrap","程序员表白","");
	for(int i=0;i<list.size();i++){
		parsonList.add(list.get(i));
	} */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style type="text/css">
	 *{
		 padding:0px ;
		 margin: 2px;		
	  }
  	  ul li a:hover{	/*  元素：hover  ：设置元素在鼠标悬停时的样式 */
           color:red;
           font-family: inherit;
       }
      ul,li{
      	margin-left:8px;
      	padding-top:0;
      	list-style-type: none;
      }    
    </style>
     <script type="text/javascript">
        function getObject(objectId){
            if(document.getElementById && document.getElementById(objectId)){
                return document.getElementById(objectId);
            }else if(document.all && document.all(objectId)){
                return document.all(objectId);
            }else if(document.layers && document.layers[objectId]){
                return document.layers[objectId];
            }else{
                return false;
            }
        }
        function showHide(e,objIdname){
            var obj = getObject(objIdname);
            if(obj.style.display == "none"){
                obj.style.display = "block";
                e.className="minus";
            }else{
                obj.style.display = "none";
                e.className="plus";
            }
        }        
    </script>
</head>

<body>
	<div class="nav_menu">
    <dl>
        <dt><a href="javascript:void(0);"  onclick="showHide(this,'items0');">web前端课程</a></dt>
        <dd id="items0" style="display:none;">
            <ul> 
                <li>	
                	<%
                		for(int i=0;i<parsonList.size();i++){	
              	 	 %>		                	              
                    <dt><a href="javascript:void(0);" onclick="showHide(this,'<%=parsonList.get(i)%>');"><%=parsonList.get(i) %></a></dt>                  
                    <ul id="<%=parsonList.get(i)%>" style="display:none;">
                     	   <%   
                     			List<String> strparson = new ArrayList();
                     	   		String strName = parsonList.get(i).toString();
                     			strparson = getName(strName,request);
                     			for(int j=0;j<strparson.size();j++){		
                     				if(strparson.get(j).toString().endsWith(".html")){
                     		%>	                 		
            				<li><a href="<%=parsonList.get(i)+"/"+strparson.get(j) %>" target="f2"><%=strparson.get(j) %></a></li>
            				<%
                      				}
            					}
            				 %>
                    </ul>
                    <%         					
          				}
          			%> 
                </li>          
            </ul>
        </dd>
    </dl>

    <dl>
        <dt><a href="javascript:void(0);" class="plus" onclick="showHide(this,'items1');">web后端课程</a></dt>
        <dd id="items1" style="display:none;">
            <ul>
                <li><a href="javascript:void(0);">servlet</a></li>
                <li><a href="javascript:void(0);">struts2</a></li>
                 <li><a href="javascript:void(0);">mybatis</a></li>
                <li><a href="javascript:void(0);">hibernate4.0</a></li>
                <li><a href="javascript:void(0);">spring</a></li>
                <li><a href="javascript:void(0);">springmvc</a></li>
                <li><a href="javascript:void(0);">ssh</a></li>
				 <li><a href="javascript:void(0);">ssm</a></li>
            </ul>
        </dd>
    </dl>
</div>
	
</body>
</html>