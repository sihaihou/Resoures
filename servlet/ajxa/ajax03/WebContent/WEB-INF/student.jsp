<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js""></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.blockUI.js"></script>
<!-- 
	1,获取 #school 节点，添加 change 响应事件
	2,使 #grade 只保留第一个option 子节点
	3,获取#school 选择的值，若该值为"",即选择的是"请选择...",此时不需要发送请求。
	4,若值不为"",说明的确是发生了改变，准备ajax请求。
	4.1, url:gradeServlet?method=gradeList
	4.2,args:school,time
	5,返回的是一个JSON数组
	5.1,若返回的数组中的元素个数为0：提示："当前学院没有班级"
	5.2,若返回的数组中的元素个数不为0:遍历：创建<option value="gradeId">gradeName</option>，并把新创建的option 节点加为grade的子节点
-->
<script type="text/javascript">

 	$(function() {
 		//  blockUI
 		$(document).ajaxStart(function() {
			$.blockUI({
				message:$("#loading"),
				css:{
					top:($(window).height()-200)/2 + 'px',	
					left:($(window).width()-400)/2 + 'px',	
					width:'400px',
					border:'none'
				},
				overlayCSS:{backgroundColor:'#fff'}
			})
		}).ajaxStop($.unblockUI);	
 		
		$("#school").change(function() {
			$("#grade option:not(:first)").remove();
			var school = $(this).val();
			if(school != ""){
				var url = "schoolServlet?method=gradeList";
				var args = {"schoolId":school,"time":new Date()};
				$.getJSON(url,args,function(data){
					if(data.length == 0){
						alert("当前学院没有年级！");
					}else{
						for(var i = 0;i < data.length ; i++){
							var gradeId = data[i].gradeId;
							var gradeName = data[i].gradeName;
							$("#grade").append("<option value='"+gradeId+"'>"+gradeName+"</option>");
						}
					}
				});
			}
			
		});
		$("#grade").change(function() {
			$("#student option:not(:first)").remove();
			var grade = $(this).val();
			if(grade != ""){
				var url = "schoolServlet?method=studentList";
				var args = {"gradeId":grade,"time":new Date()};
				$.getJSON(url,args,function(data){
					if(data.length == 0){
						alert("当前班级没有学生！");
					}else{
						for(var i = 0;i < data.length ; i++){
							var studentId = data[i].studentId;
							var studentName = data[i].studentName;
							$("#student").append("<option value='"+studentId+"'>"+studentName+"</option>");
						}
					}
				});
			}		
		});
		$("#student").change(function() {			
			var student = $(this).val();
			if(student != ""){
				var url = "schoolServlet?method=getStudent";
				var args = {"studentId":student,"time":new Date()};
				$.getJSON(url,args,function(data){
					var studentId = data.studentId;
					var studentName = data.studentName;
					var studentAge = data.studentAge;
					var studentPhone = data.studentPhone;
					$("#empdetails").show();
					$("#studentId").html("<a href='"+studentId+"'>"+studentId+"</a>");
					$("#studentId").val(studentId);
					$("#studentName").html(studentName);
					$("#studentAge").html(studentAge);
					$("#studentPhone").html(studentPhone);
				});
			}		
		});
		$("#studentId").blur(function () {
			alert("aaa");
		});
	})
</script>
</head>
<body>
	<img alt="" src="images/loading.gif" id="loading" style="display: none">
	<center>
		<br><br>
		学院：
		<select id="school">
			<option value="">请选择...</option>
			<c:forEach items="${schools}" var="bean">
				<option value="${bean.schoolId }">${bean.schoolName }</option>
			</c:forEach>
		</select>
		&nbsp;&nbsp;&nbsp;
		
		专业班级：
		<select id="grade">
			<option value="">请选择...</option>
		</select>
		&nbsp;&nbsp;&nbsp;
		
		学生：
		<select id="student">
			<option value="">请选择...</option>
		</select>
		&nbsp;&nbsp;&nbsp;
		
		<br><br>		
		<table id="empdetails" border="1" align="center" cellspacing="0" cellpadding="5" width="50%" style="display:none">
			<thead>
				<tr align="center">
					<th>编号</th>
					<th>姓名</th>
					<th>年龄</th>
					<th>联系方式</th>
				</tr>	
			</thead>		
			<tbody align="center">
				<tr>
					<td id="studentId"></td>
					<td id="studentName"></td>
					<td id="studentAge"></td>
					<td id="studentPhone"></td>
				</tr>
			</tbody>
		</table>
	</center>
</body>
</html>