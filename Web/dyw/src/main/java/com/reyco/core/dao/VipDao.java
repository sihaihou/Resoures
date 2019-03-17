package com.reyco.core.dao;

import java.util.List;
import java.util.Map;

import com.reyco.core.pojo.Vip;

public interface VipDao {
	
	/**
	 * 下拉条
	 * @return
	 */
	public List<Vip> searchList(Integer size);
	/**
	 * vip分页
	 * @param map
	 * @return
	 */
	@Deprecated
	public List<Vip> searchPage(Map<String,Object> map);
	/**
	 * vip分页
	 * @param map
	 * @return
	 */
	public List<Vip> searchPage(Vip vip);
	/**
	 * 新增vip
	 * @param map
	 */
	@Deprecated
	public void insertVip(Map<String,Object> map);
	/**
	 * 新增vip
	 * @param map
	 */
	public void insertVip(Vip vip);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Vip searchById(Integer id);
	/**
	 * 编辑
	 * @param map
	 */
	@Deprecated
	public void updateVip(Map<String,Object> map);
	/**
	 * 编辑
	 * @param map
	 */
	public void updateVip(Vip vip);
}
