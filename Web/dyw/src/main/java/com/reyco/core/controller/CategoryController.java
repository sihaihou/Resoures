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
import com.reyco.core.pojo.Category;
import com.reyco.core.service.CategoryService;
import com.reyco.core.util.JSONResult;
import com.reyco.core.util.PageUtil;

@RequestMapping("/category")
@Controller("categoryController")
public class CategoryController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private CategoryService categoryService;
	
	@ResponseBody
	@RequestMapping("/searchList")
	public String searchList() {
		Integer status = 0;
		List<Category> categorys = categoryService.searchList(status);
		if(categorys == null || categorys.size() < 1) {
			return JSONResult.noDataCreate().toJSON();
		}
		return JSONResult.create(categorys).toJSON();
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
	public String searchPage(Integer pageNo,String name, Integer status, String gmtCreate) {
		if(pageNo < 1) {
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_SELECT).toJSON();
		}
		List<Category> list = categoryService.searchPage(pageNo,name, status, gmtCreate);
		if(list.size() < 1) {
			return JSONResult.noDataCreate().toJSON();
		}
		PageInfo<Category> pageInfo = new PageInfo<Category>(list);
		return JSONResult.create(PageUtil.getPage(pageInfo)).toJSON();
	}
	/**
	 * 添加
	 * @param name
	 * @param desc
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insertCategory")
	public String insertCategory(String name, String desc) {
		if(StringUtils.isBlank(name)) {
			return JSONResult.failCreate(JSONResult.INSERT_FAIL,JSONResult.ERROR_PARAMS).toJSON();
		}
		if(StringUtils.isBlank(desc)) {
			desc = "点击修改备注";
		}
		Integer quantity = 0;
		Integer status = Status.NORMAL;
		categoryService.insertCategory(name, quantity, status, desc);
		return JSONResult.create("新增成功").toJSON();
	}
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/searchById")
	public String searchById(Integer id) {
		if(null == id || id < 1) {
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_PARAMS).toJSON();
		}
		Category category = categoryService.searchById(id);
		if(null == category) {
			return JSONResult.noDataCreate().toJSON();
		}
		return JSONResult.create(category).toJSON();
	}
	@ResponseBody
	@RequestMapping("/updateCategory")
	public String updateCategory(Integer id,String name,Integer quantity,Integer status,String desc) {
		if(null == id || id < 1) {
			return JSONResult.failCreate(JSONResult.UPDATE_FAIL,JSONResult.ERROR_PARAMS).toJSON();
		}
		categoryService.updateCategory(id, name, null,quantity, status, desc);
		return JSONResult.create("修改成功").toJSON();
	}
	/**
	 * 查询列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/searchNav")
	public String searchNav(){
		List<Category> navList = categoryService.searchNav();
		if(navList.size() < 1) {
			return JSONResult.noDataCreate().toJSON();
		}
		return JSONResult.create(navList).toJSON();
	}
}
