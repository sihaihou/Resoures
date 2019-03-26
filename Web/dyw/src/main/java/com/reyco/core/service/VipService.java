package com.reyco.core.service;

import java.util.List;

import com.reyco.core.pojo.Vip;

public interface VipService {
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
	public List<Vip> searchPage(Integer pageNo,String name);
	/**
	 * 新增vip
	 * @param map
	 */
	public void insertVip(String name,Integer lowVip,Integer higVip,Integer status,String desc);
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
	public void updateVip(Integer id,String name,Integer lowVip,Integer higVip,Integer status,String desc);
}
