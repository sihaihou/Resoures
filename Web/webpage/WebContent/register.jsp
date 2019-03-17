<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表单验证</title>
    <script>
            String.prototype.trim = function(){
                return this.replace(/^\s+/,"").replace(/\s+$/,"");
            };
            //   1。用户名验证
            //提示错误
            function checkName(username){
                var nameOk = false;
                var userNameError = document.getElementById("usernameError");
                username  = username.trim();
                if(username.length >= 4 && username.length <= 10){
                    userNameError.innerHTML = "<font color='green'>用户名可以使用</font>";
                    nameOk = true;
                }else if(username.length == 0){
                    userNameError.innerHTML = "<font color='red'>用户名不能为空</font>";
                    nameOk = false;
                }else{
                    userNameError.innerHTML = "<font color='red'>用户名长度为4-10个字符</font>";
                    nameOk = false;
                }
                return nameOk;
            }
            //获取焦点清除span标签
            function clearNameError(){
                var usernameError = document.getElementById("usernameError");
                usernameError.innerHTML = "";
                var passwordError = document.getElementById("passwordError");
                passwordError.innerHTML = "";
                var confirmPasswordError = document.getElementById("confirmPasswordError");
                confirmPasswordError.innerHTML = "";
            }

            //   2。密码验证
            function checkPassword(password){
                var passwordOk = false;
                var passwordError = document.getElementById("passwordError");
                password  = password.trim();
                if(password.length >= 6 && password.length <= 16){
                    passwordError.innerHTML = "<font color='green'>密码可以使用</font>";
                    passwordOk = true;
                }else if(password.length == 0){
                    passwordError.innerHTML = "<font color='red'>密码不能包含空格</font>";
                    passwordOk = false;
                }else{
                    passwordError.innerHTML = "<font color='red'>密码长度为6-16个字符</font>";
                    passwordOk = false;
                }
                return passwordOk;
            }
            //获取焦点清除span标签
            function clearPasswordError(){
                var passwordError = document.getElementById("passwordError");
                passwordError.innerHTML = "";
                var confirmPasswordError = document.getElementById("confirmPasswordError");
                confirmPasswordError.innerHTML = "";
            }

            //  2。确认密码验证
            function checkcConfirmPassword(){
                var confirmOk = false;
                var password = document.getElementById("password").value;
                var confirmPassword = document.getElementById("confirmPassword").value;
                var confirmPasswordError = document.getElementById("confirmPasswordError");
                if(password.length == confirmPassword.length && password.length == 0){
                    confirmPasswordError.innerHTML = "<font color='red'>密码不能包含空格</font>";
                    confirmOk = false;
                }else if(password == confirmPassword && password.length != 0 ){
                   if( confirmPassword.length >= 6 && confirmPassword.length <= 16 ){
                       confirmPasswordError.innerHTML = "<font color='green'>密码正确</font>";
                       confirmOk = true;
                   }else{
                       confirmPasswordError.innerHTML = "<font color='red'>密码长度为6-16个字符</font>";
                       confirmOk = false;
                   }
                }else{
                    confirmPasswordError.innerHTML = "<font color='red'>密码不一致，请重新输入</font>";
                    confirmOk = false;
                }
                return confirmOk;
            }
            function clearConfirmPasswordError(){
                var confirmPasswordError = document.getElementById("confirmPasswordError");
                confirmPasswordError.innerHTML = "";
            }



            function checkForm(){
               //获取用户名username
                var username = document.getElementById("username").value;
                var password = document.getElementById("password").value;
                //不合法则放弃提交表单，提示错误
                var usernameOk = checkName(username);
                var passwordOK = checkPassword(password);
                var confirmPasswordOK = checkcConfirmPassword();

                //if(checkName(username) && checkPassword(password)  && checkcConfirmPassword())
                if(usernameOk && passwordOK  && confirmPasswordOK){
                    //合法这提交表单
                    // 1.先获取表单对象，因为一个网页中可以有多个表单。
                    document.forms["userForm"].action = "success.jsp";
                    document.forms["userForm"].method = "post";
                    //document.forms["formName"].submit();
                    document.forms["userForm"].submit();

                }
            }
    </script>
</head>
<body>
    <form name="userForm">
        用户<input type="text" name="username" id="username" onblur="checkName(this.value);" onfocus="clearNameError();">
        <span id="usernameError"></span><br>

        密码<input type="password" name="password" id="password" onblur="checkPassword(this.value);" onfocus="clearPasswordError();">
        <span id="passwordError"></span><br>

        确认密码<input type="password" name="confirmPassword" id="confirmPassword" onblur="checkcConfirmPassword();" onfocus="clearConfirmPasswordError();">
        <span id="confirmPasswordError"></span><br>

        <input type="button" value="注册" onclick="checkForm();">
    </form>
</body>
</html>