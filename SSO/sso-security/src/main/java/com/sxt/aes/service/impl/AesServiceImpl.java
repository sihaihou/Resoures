package com.sxt.aes.service.impl;

import org.springframework.stereotype.Service;

import com.sxt.aes.service.AesService;
import com.sxt.aes.utils.AesCrypt;
import com.sxt.aes.utils.AesResponse;

@Service
public class AesServiceImpl implements AesService {

	@Override
	public AesResponse testAes(String key, String securityMessage, String name, String password) {
		System.out.println("接收到的密文： " + securityMessage);
		System.out.println("请求参数name：" + name + " ； 请求参数password：" + password);
		System.out.println("请求key： " + key);
		AesResponse resp = new AesResponse();
		String respKey = AesCrypt.getKEY();
		String message = "";
		
		// 解密解析请求数据
		try{
			// 解密得到请求源参数
			String decodeMessage = AesCrypt.aesDecrypt(securityMessage, key);
			System.out.println("解密后的数据：" + decodeMessage);
			// 校验请求参数
			if(!decodeMessage.equals((name + password))){
				// 请求参数校验失败
				message = "请求数据被篡改！";
			}else{
				// 请求参数验证成功
				message = "登录成功！";
			}
		}catch(Exception e){
			e.printStackTrace();
			// 有解密异常发生。
			message = "请求数据解析错误！";
		}
		
		System.out.println("响应中的key：" + respKey);
		System.out.println("响应消息明文：" + message);
		// 加密处理响应数据
		try{
			message = AesCrypt.aesEncrypt(message, respKey);
		}catch(Exception e){
			e.printStackTrace();
			// 加密异常发生。
			return null;
		}
		System.out.println("响应消息密文：" + message);
		resp.setKey(respKey);
		resp.setSecurityMessage(message);
		
		return resp;
		
	}

}
