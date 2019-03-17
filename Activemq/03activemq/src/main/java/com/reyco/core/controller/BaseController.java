package com.reyco.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reyco.core.domain.MailContent;
import com.reyco.core.service.BaseService;
import com.reyco.core.service.QueueProducerService;
import com.reyco.core.util.JSONResult;

import redis.clients.jedis.JedisCluster;

@RequestMapping("base")
@Controller("baseController")
public class BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	public BaseService baseService;
	@Autowired
	public JedisCluster jedisCluster;
	
	@Autowired
	private QueueProducerService messageService;
	
	@ResponseBody
	//@RequestMapping(value = "login", method = RequestMethod.POST)
	@RequestMapping(value = "login")
	public String searchList() {
		return JSONResult.create("login").toJSON();
	}	
	
	@ResponseBody
	@RequestMapping("redis")
	public String redis() {
		String a = jedisCluster.get("a");
		String b = jedisCluster.get("b");
		String c = jedisCluster.get("c");
		String d = jedisCluster.get("d");
		String e = jedisCluster.get("e");
		String age = jedisCluster.get("age");
		List<String> list = new ArrayList<String>();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		list.add(age);
		return JSONResult.create(list).toJSON();
	}
	@ResponseBody
	@RequestMapping("send")
	public String redis(String from,String to,String subject,String text) {
		if(StringUtils.isBlank(to) || StringUtils.isBlank(subject) || StringUtils.isBlank(text) ) {
			return JSONResult.failCreate("发送失败", "").toJSON();
		}
		MailContent mailContent = new MailContent(to,subject,text);
		System.out.println("baseController--------mailContent-----"+mailContent);
		messageService.sendTextMessage(mailContent);
		return JSONResult.create("发送成功").toJSON();
	}
	@ResponseBody
	@RequestMapping("test")
	public String test(String from,String to,String subject,String text) {
		MailContent mailContent = new MailContent(from,to, subject, text);
		messageService.sendMail(mailContent);
		return JSONResult.create("发送成功").toJSON();
	}
	
	
}
