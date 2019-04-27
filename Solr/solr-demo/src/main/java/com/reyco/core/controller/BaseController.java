package com.reyco.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reyco.core.domain.Base;
import com.reyco.core.service.BaseService;
import com.reyco.core.util.JSONResult;
import com.reyco.core.util.PageUtil;

import redis.clients.jedis.JedisCluster;

@RequestMapping("base")
@Controller("baseController")
public class BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	public BaseService baseService;
	@Autowired
	public JedisCluster jedisCluster;
	
	@ResponseBody
	//@RequestMapping(value = "login", method = RequestMethod.POST)
	@RequestMapping(value = "login")
	public String searchList(String name) {
		if(null == name) {
			logger.info("############################################请求参数错误--+name==="+name);
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_PARAMS).toJSON();
		}
		List<Base> list = baseService.searchList(name);
		logger.info("############################################查询成功--+list====="+list);
		return JSONResult.create(list).toJSON();
	}
	
	@ResponseBody
	@RequestMapping("/insert")
	public String insert(String name,String password) {
		if(null == name) {
			logger.info("############################################请求参数错误--+name==="+name);
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_PARAMS).toJSON();
		}
		if(null == password) {
			logger.info("############################################请求参数错误--+password==="+password);
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_PARAMS).toJSON();
		}
		Base base = new Base(name,password);
		baseService.insert(base);
		return JSONResult.create(JSONResult.INSERT_SUCCESS).toJSON();
	}
	
	@ResponseBody
	@RequestMapping("/searchById")
	public String searchById(Integer id) {
		if(null == id) {
			logger.info("############################################请求参数错误--+id==="+id);
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_PARAMS).toJSON();
		}
		Base base = baseService.searchById(id);
		return JSONResult.create(base).toJSON();
	}
	
	@ResponseBody
	@RequestMapping("/updateById")
	public String updateById(Integer id,String name,String password) {
		if(null == id) {
			logger.info("############################################请求参数错误--+id==="+id);
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_PARAMS).toJSON();
		}
		Base base = new Base(id,name,password);
		baseService.updateById(base);
		return JSONResult.create(JSONResult.UPDATE_SUCCESS).toJSON();
	}
	
	@ResponseBody
	@RequestMapping("/searchPage")
	public String searchPage(Integer pageNo,String name) {
		if(null == pageNo) {
			logger.info("############################################请求参数错误--+pageNo==="+pageNo);
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_PARAMS).toJSON();
		}
		Base base = new Base(name);
		PageHelper.startPage(pageNo,PageUtil.PAGESIZE);
		PageInfo<Base> pageInfo = baseService.searchPage(base);
		List<Base> list = pageInfo.getList();
		if(list.size() < 1) {
			logger.info("################################没有数据: list === "+list);
			return JSONResult.noDataCreate().toJSON();
		}
		return JSONResult.create(PageUtil.getPage(pageInfo)).toJSON();
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
	
	
	
}
