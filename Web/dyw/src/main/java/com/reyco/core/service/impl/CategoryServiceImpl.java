package com.reyco.core.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.reyco.core.dao.CategoryDao;
import com.reyco.core.pojo.Category;
import com.reyco.core.service.CategoryService;
import com.reyco.core.util.DateUtil;
import com.reyco.core.util.PageUtil;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	/**
	 * 下拉列表
	 */
	@Override
	public List<Category> searchList(Integer status) {
		return categoryDao.searchList(status);
	}
	/**
	 * 分页
	 */
	@Override
	public List<Category> searchPage(Integer pageNo,String name, Integer status, String gmtCreate) {
		PageHelper.startPage(pageNo,PageUtil.PAGESIZE);
		Date gmtCreateDate = DateUtil.parseDateTime(gmtCreate);
		Category category = new Category(name,status,gmtCreateDate);
		return categoryDao.searchPage(category);
	}
	/**
	 * 新增
	 */
	@Override
	public void insertCategory(String name, Integer quantity, Integer status, String desc) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("quantity", quantity);
		map.put("status", status);
		map.put("desc", desc);
		categoryDao.insertCategory(map);
	}
	/**
	 * 根据id查询
	 */
	@Override
	public Category searchById(Integer id) {
		return categoryDao.searchById(id);
	}
	/**
	 * 编辑
	 */
	@Override
	public void updateCategory(Integer id, String name, Integer activeQuantity,Integer quantity, Integer status, String desc) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("name", name);
		map.put("activeQuantity", activeQuantity);
		map.put("quantity", quantity);
		map.put("status", status);
		map.put("desc", desc);
		categoryDao.updateCategory(map);
	}
	@Override
	public List<Category> searchNav() {
		return categoryDao.searchNav();
	}

}
