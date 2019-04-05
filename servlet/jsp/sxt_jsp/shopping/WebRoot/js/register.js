function checkform(myform) {
	/* var ssn = myform.username.value.toLowerCase();
	if(!checkusername(ssn)) return false;
	
	if(myform.password.value)<6||(myform.password.value)>16)){
		alert("\密码长度为6-16位，仅可使用字母、数字、特殊字符!");
		myform.password.focus();
		return false;
	} 
	 if(atrlen(myform.password.value)){
		alert("\你的密码包含非法字符，仅可使用字母、数字、特殊字符!");
		myform.password.focus();
		return false;
	}  */
		if((myform.username.value.length)<2||(myform.username.value.length)>6){
			alert("用户名长度为2-6位，仅可使用字母、数字、特殊字符!");
			myform.password.focus();
			return false;
		}
		 if((myform.password.value.length)<6||(myform.password.value.length)>16){
			alert("密码长度为6-16位，仅可使用字母、数字、特殊字符!");
			myform.password.focus();
			return false;
		}
		if(myform.username.value==""){
			alert("用户名不能为空");
			myform.username.focus();
			return false;
		}	
		if(myform.password.value==myform.username.value){
			alert("用户名和密码不能相同");
			myform.password.focus();
			return false;
		}	
		
		if(myform.password.value==""){
			alert("密码不能为空");
			myform.password.focus();
			return false;
		}	
		if(myform.phone.value==""){
			alert("请填写电话");
			myform.password.focus();
			return false;
		}	
		if(myform.addr.value==""){
			alert("地址不能为空");
			myform.password.focus();
			return false;
		}		
	}