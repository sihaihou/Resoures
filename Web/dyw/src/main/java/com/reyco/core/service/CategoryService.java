package com.reyco.core.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.reyco.core.pojo.Category;

public interface CategoryService {
	/**
	 * 下拉列表
	 * @param status
	 * @return
	 */
	public List<Category> searchList(Integer status);
	/**
	 * 分页
	 * @param name
	 * @param status
	 * @param gmtCreate
	 * @return
	 */
	public List<Category> searchPage(Integer pageNo,String name,Integer status,String gmtCreate);
	/**
	 * 新增
	 * @param name
	 * @param quantity
	 * @param status
	 * @param desc
	 */
	public void insertCategory(String name,Integer quantity,Integer status,String desc);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Category searchById(Integer id);
	/**
	 * 编辑
	 * @param id
	 * @param name
	 * @param quantity
	 * @param status
	 * @param desc
	 */
	public void updateCategory(Integer id,String name,Integer activeQuantity,Integer quantity,Integer status,String desc);
	/**
	 * 导航条
	 * @return
	 */
	public List<Category> searchNav();
}
