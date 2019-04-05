package com.sxt.des.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.des.utils.DesResponse;
import com.sxt.service.DesService;

@Controller
public class DesController {
	
	@Autowired
	private DesService desService;
	
	/**
	 * 加密逻辑为： name+password 使用key作为密匙源，加密得到securityMessage
	 * @param key 密匙源
	 * @param securityMessage 加密后的签名
	 * @param name 用户名
	 * @param password 密码
	 * @return
	 */
	@RequestMapping("/testDes")
	@ResponseBody
	public DesResponse testDes(@RequestParam("key") String key, @RequestParam("message") String securityMessage
			, @RequestParam("name") String name, @RequestParam("password") String password){
		
		DesResponse resp = this.desService.testDes(key, securityMessage, name, password);
		
		return resp;
	}
	
}
