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
<%	
	String[] fileName ={"css","html","jQuery","javascript","bootstrap","程序员表白" };  
	List htmlList = new ArrayList();
	htmlList = getName(fileName[1],request);
	request.setAttribute("htmlList",htmlList ); 
	
	 List cssList = new ArrayList();
	 cssList = getName(fileName[0],request);
	 request.setAttribute("cssList",cssList );  
	
	List jQueryList = new ArrayList();
	jQueryList = getName(fileName[2],request);
	request.setAttribute("jQueryList",jQueryList ); 
	
    List javascriptList = new ArrayList();
	javascriptList = getName(fileName[3],request);
	request.setAttribute("javascriptList",javascriptList ); 
	
	List bootstrapList = new ArrayList();
	bootstrapList = getName(fileName[4],request);
	request.setAttribute("bootstrapList",bootstrapList );
	
	List cxyList = new ArrayList();
	cxyList = getName(fileName[5],request);
	request.setAttribute("cxyList",cxyList );
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
                    <dt><a href="javascript:void(0);" onclick="showHide(this,'items0_1');">javascript</a></dt>
                    <ul id="items0_1" style="display:none;">
                      		<%
            					for(int i=0;i<javascriptList.size();i++){
            						if(javascriptList.get(i).toString().endsWith(".html")){
            				%>
            				<li><a href="<%="javascript/"+javascriptList.get(i) %>" target="f2"><%=javascriptList.get(i) %></a></li>
            				<%
            						}
            					}
            				%>
                    </ul>
                </li>
                <li>
                    <dt><a href="javascript:void(0);" onclick="showHide(this,'items0_2');">css</a></dt>
                    <ul id="items0_2" style="display:none;">
                        <%
           					for(int i=0;i<cssList.size();i++){
           						if(cssList.get(i).toString().endsWith(".html")){
           				%>
           				<li ><a href="<%="css/"+cssList.get(i) %>" target="f2" ><%=cssList.get(i) %></a></li>
           				<%
           						}
           					}
           				%>
                    </ul>
                </li>
                
                 <li>
                    <dt><a href="javascript:void(0);" onclick="showHide(this,'items0_3');">jQuery</a></dt>
                    <ul id="items0_3" style="display:none;">
                        <%
           					for(int i=0;i<jQueryList.size();i++){
           						if(jQueryList.get(i).toString().endsWith(".html")){
           				%>
           				<li ><a href="<%="jQuery/"+jQueryList.get(i) %>" target="f2" ><%=jQueryList.get(i) %></a></li>
           				<%
           						}
           					}
           				%>
                    </ul>
                </li>
                
                <li>
                    <dt><a href="javascript:void(0);" onclick="showHide(this,'items0_4');">html</a></dt>
                    <ul id="items0_4" style="display:none;">
                        <%
           					for(int i=0;i<htmlList.size();i++){
           						if(htmlList.get(i).toString().endsWith(".html")){
           				%>
           				<li ><a href="<%="html/"+htmlList.get(i) %>" target="f2" ><%=htmlList.get(i) %></a></li>
           				<%
           						}
           					}
           				%>
                    </ul>
                </li>
                
                <li>
                    <dt><a href="javascript:void(0);" onclick="showHide(this,'items0_5');">bootstrap</a></dt>
                    <ul id="items0_5" style="display:none;">
                        <%
           					for(int i=0;i<bootstrapList.size();i++){
           						if(bootstrapList.get(i).toString().endsWith(".html")){
           				%>
           				<li ><a href="<%="bootstrap/"+bootstrapList.get(i) %>" target="f2" ><%=bootstrapList.get(i) %></a></li>
           				<%
           						}
           					}
           				%>
                    </ul>
                </li>
                
                 <li>
                    <dt><a href="javascript:void(0);" onclick="showHide(this,'items0_6');">程序员表白</a></dt>
                    <ul id="items0_6" style="display:none;">
                        <%
           					for(int i=0;i<cxyList.size();i++){
           						if(cxyList.get(i).toString().endsWith(".html")){
           				%>	
           				<li ><a href="<%="程序员表白/"+cxyList.get(i) %>" target="f2" ><%=cxyList.get(i) %></a></li>	     
           				<%
           						}
           					}
           				%>
                    </ul>
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