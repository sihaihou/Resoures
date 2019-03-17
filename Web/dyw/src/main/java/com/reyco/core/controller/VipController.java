package com.reyco.core.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.reyco.core.constant.Status;
import com.reyco.core.pojo.Vip;
import com.reyco.core.service.VipService;
import com.reyco.core.util.JSONResult;
import com.reyco.core.util.PageUtil;

@RequestMapping("/vip")
@Controller("vipController")
public class VipController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private VipService vipService;

	@ResponseBody
	@RequestMapping("/searchList")
	public String searchList(Integer size) {
		if(null==size || size < 1) {
			return JSONResult.failCreate("", "").toJSON();
		}
		List<Vip> vips = vipService.searchList(size);
		if(vips == null || vips.size() < 1) {
			return JSONResult.noDataCreate().toJSON();
		}
		return JSONResult.create(vips).toJSON();
	}
	/**
	 * 分页
	 * @param pageNo
	 * @param name
	 * @param status
	 * @param gmtCreate
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/searchPage")
	public String searchPage(Integer pageNo,String name) {
		if(pageNo < 1) {
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_SELECT).toJSON();
		}
		List<Vip> list = vipService.searchPage(pageNo,name);
		if(list.size() < 1) {
			return JSONResult.noDataCreate().toJSON();
		}
		PageInfo<Vip> pageInfo = new PageInfo<Vip>(list);
		return JSONResult.create(PageUtil.getPage(pageInfo)).toJSON();
	}
	/**
	 * 添加
	 * @param name
	 * @param desc
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insertVip")
	public String insertVip(String name,Integer lowVip,Integer higVip,String desc) {
		if(StringUtils.isBlank(name)) {
			return JSONResult.failCreate(JSONResult.INSERT_FAIL,JSONResult.ERROR_PARAMS).toJSON();
		}
		if(null == lowVip) {
			return JSONResult.failCreate(JSONResult.INSERT_FAIL,JSONResult.ERROR_PARAMS).toJSON();
		}
		if(null == higVip) {
			return JSONResult.failCreate(JSONResult.INSERT_FAIL,JSONResult.ERROR_PARAMS).toJSON();
		}
		if(lowVip >= higVip) {
			return JSONResult.failCreate("新增失败,higVip值不能小于lowVip值",JSONResult.ERROR_PARAMS).toJSON();
		}
		if(StringUtils.isBlank(desc)) {
			desc = "点击修改备注";
		}
		Integer status = Status.NORMAL;
		vipService.insertVip(name,lowVip,higVip,status,desc);
		return JSONResult.create("添加成功").toJSON();
	}
	/**
	 * 根据 id查询
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/searchById")
	public String searchById(Integer id) {
		if(null == id || id < 0) {
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_PARAMS).toJSON();
		}
		Vip vip = vipService.searchById(id);
		if(null == vip) {
			return JSONResult.noDataCreate().toJSON();
		}
		return JSONResult.create(vip).toJSON();
	}
	@ResponseBody
	@RequestMapping("/updateVip")
	public String updateVip(Integer id,String name,Integer lowVip,Integer higVip,Integer status,String desc) {
		if(null == id || id < 0) {
			return JSONResult.failCreate(JSONResult.UPDATE_FAIL,JSONResult.ERROR_PARAMS).toJSON();
		}
		if(null == lowVip) {
			return JSONResult.failCreate(JSONResult.INSERT_FAIL,JSONResult.ERROR_PARAMS).toJSON();
		}
		if(null == higVip) {
			return JSONResult.failCreate(JSONResult.INSERT_FAIL,JSONResult.ERROR_PARAMS).toJSON();
		}
		if(lowVip >= higVip) {
			return JSONResult.failCreate("编辑失败,higVip值不能小于lowVip值",JSONResult.ERROR_PARAMS).toJSON();
		}
		vipService.updateVip(id,name,lowVip,higVip,status,desc);
		return JSONResult.create("编辑成功").toJSON();
	}
}
