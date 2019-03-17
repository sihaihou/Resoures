package com.reyco.core.dao;

import java.util.List;
import java.util.Map;

import com.reyco.core.pojo.Category;

public interface CategoryDao {
	
	/**
	 *  下拉列表
	 * @param status
	 * @return
	 */
	public List<Category> searchList(Integer status);
	/**
	 * 导航条
	 * @return
	 */
	public List<Category> searchNav();
	/**
	 * 类别分页
	 * @param map
	 * @return
	 */
	@Deprecated
	public List<Category> searchPage(Map<String,Object> map);
	/**
	 * 类别分页
	 * @param map
	 * @return
	 */
	public List<Category> searchPage(Category category);
	
	/**
	 * 新增类别
	 * @param map
	 */
	public void insertCategory(Map<String,Object> map);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Category searchById(Integer id);
	/**
	 * 编辑
	 * @param map
	 */
	public void updateCategory(Map<String,Object> map);
	
	
}
