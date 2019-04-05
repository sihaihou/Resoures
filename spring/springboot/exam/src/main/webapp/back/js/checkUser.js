/**
 * 验证是否登录:未登录则跳到登录页面
 * @returns
 */
$(function(){
	    checkUser();
});
/**
 * 验证是否登录
 * @returns
 */
function checkUser(){
    $.ajax({
        type:'post',
        dataType: "json",
        url:"../student/checkUser.do",
        data:{ time:new Date()},
        success:function(data){
        	var flag = data.success;
        	if(flag){
        		//已登录
        	}else{
        		$(location).attr('href', '../');
        	}
        },
        error:function(){
        	$(location).attr('href', '../user/login.html');
        }
    });
}