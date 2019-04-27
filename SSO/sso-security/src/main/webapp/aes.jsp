<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title>AES算法</title>
    <script src="/js/jquery.min.js"></script>
    <script src="/js/aes.min.js"></script>
    <script>
    	// 随机数生成算法。 len-生成结果的长度， radix-生成结果的组成，是二进制，十进制还是十六进制数。
	    function uuid(len, radix) {
	        var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
	        var uuid = [], i;
	        radix = radix || chars.length;
	     
	        if (len) {
	          // Compact form
	          for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random()*radix];
	        } else {
	          // rfc4122, version 4 form
	          var r;
	     
	          // rfc4122 requires these characters
	          uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
	          uuid[14] = '4';
	     
	          // Fill in random data.  At i==19 set the high bits of clock sequence as
	          // per rfc4122, sec. 4.1.5
	          for (i = 0; i < 36; i++) {
	            if (!uuid[i]) {
	              r = 0 | Math.random()*16;
	              uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
	            }
	          }
	        }
	     
	        return uuid.join('');
	    }
        /*
         * 加密函数
         * message - 明文数据
         * key - 密钥
         */
         function encryptByAES(message, key){
       	    var keyHex = CryptoJS.enc.Utf8.parse(key);
       	    var srcs = CryptoJS.enc.Utf8.parse(message);
       	    var encrypted = CryptoJS.AES.encrypt(srcs, keyHex, {
       	    	mode:CryptoJS.mode.ECB,
       	    	padding: CryptoJS.pad.Pkcs7
       	    });
       	    return encrypted.toString();
       	}
		
        /*
         * 解密函数
         * ciphertext - 要解密的密文。
         */
         function decryptByAES(ciphertext, key){
       	    var keyHex = CryptoJS.enc.Utf8.parse(key);
       	    var decrypt = CryptoJS.AES.decrypt(ciphertext, keyHex, {
       	    	mode:CryptoJS.mode.ECB,
       	    	padding: CryptoJS.pad.Pkcs7
       	    });
       	    return CryptoJS.enc.Utf8.stringify(decrypt).toString();
       	}
        
        function doPost(){
        	var name = $("#nameText").val();
        	var password = $("#passwordText").val();
        	var message = name + password;
        	var key = uuid(32,16);
        	var param = {};
        	param.name=name;
        	param.password=password;
        	param.key=key;
        	// 正确的加密
        	param.message = encryptByAES(message, key);
        	// 测试解密错误，如：请求拦截。
        	// param.message = "WrongSecurityMessage00";
        	// 测试异常情况。AES加密后的密文数据长度一定是8的整数倍。
        	// param.message = "testException";
        	$.ajax({
        		'url':'/testAes',
        		'data':param,
        		'success':function(data){
        			if(data){
        				alert("密文："+data.securityMessage+"；key："+data.key);
        				var respMsg = decryptByAES(data.securityMessage, data.key);
        				alert(respMsg);
        			}else{
        				alert("服务器忙请稍后重试!");
        			}
        		}
        	});
        }

    </script>
</head>

<body>
	<center>
		<table>
			<caption>AES安全测试</caption>
			<tr>
				<td style="text-align: right; padding-right: 5px">
					姓名：
				</td>
				<td style="text-align: left; padding-left: 5px">
					<input type="text" name="name" id="nameText"/>
				</td>
			</tr>
			<tr>
				<td style="text-align: right; padding-right: 5px">
					密码：
				</td>
				<td style="text-align: left; padding-left: 5px">
					<input type="text" name="password" id="passwordText"/>
				</td>
			</tr>
			<tr>
				<td style="text-align: right; padding-right: 5px" colspan="2">
					<input type="button" value="测试" onclick="doPost();" />
				</td>
			</tr>
		</table>
	</center>
</body>
</html>