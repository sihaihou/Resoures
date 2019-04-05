<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title>DES算法</title>
    <script src="/js/jquery.min.js"></script>
    <script src="/js/tripledes.js"></script>
    <script src="/js/mode-ecb-min.js"></script>
    <script>
	    function uuid() {
			var s = [];
			var hexDigits = "0123456789abcdef";
			for (var i = 0; i < 36; i++) {
			  	s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
			}
			s[14] = "4"; // bits 12-15 of the time_hi_and_version field to 0010
			s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1); // bits 6-7 of the clock_seq_hi_and_reserved to 01
			s[8] = s[13] = s[18] = s[23] = "-";
			
			var uuid = s.join("");
			return uuid;
    	}
        /*
         * 加密函数
         * message - 要加密的源数据
         * key - 密钥
         */
        function encryptByDES(message, key) {
			// 解析密钥， 将密钥转换成16进制数据。 就是解析为字节数据。
            var keyHex = CryptoJS.enc.Utf8.parse(key);
			// 创建DES加密工具。 构建器。
            var encrypted = CryptoJS.DES.encrypt(message, keyHex, {
                mode: CryptoJS.mode.ECB, // 加密的模式， ECB加密模式。
                padding: CryptoJS.pad.Pkcs7 // 加密的padding
            });
            return encrypted.toString(); // 加密，并获取加密后的密文数据。
        }
		
        /*
         * 解密函数
         * ciphertext - 要解密的密文数据。
         * key - 密钥
         */
        function decryptByDES(ciphertext, key) {

            var keyHex = CryptoJS.enc.Utf8.parse(key);
            // 创建解密工具
            var decrypted = CryptoJS.DES.decrypt({
                ciphertext: CryptoJS.enc.Base64.parse(ciphertext) // 将密文数据解析为可解密的字节数据。
            }, keyHex, {
                mode: CryptoJS.mode.ECB,
                padding: CryptoJS.pad.Pkcs7
            });
            return decrypted.toString(CryptoJS.enc.Utf8); // 解密过程，并返回明文。
        }

        function doPost(){
        	var name = $("#nameText").val();
        	var password = $("#passwordText").val();
        	var message = name + password;
        	var key = uuid();
        	var param = {};
        	param.name=name;
        	param.password=password;
        	param.key=key;
        	// 正确的加密
        	param.message = encryptByDES(message, key);
        	// 测试解密错误，如：请求拦截。
        	// param.message = "WrongSecurityMessage00";
        	// 测试异常情况。DES加密后的密文数据长度一定是8的整数倍。
        	// param.message = "testException";
        	$.ajax({
        		'url':'/testDes',
        		'data':param,
        		'success':function(data){
        			if(data){
        				alert("密文："+data.securityMessage+"；key："+data.key);
        				var respMsg = decryptByDES(data.securityMessage, data.key);
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
			<caption>DES安全测试</caption>
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