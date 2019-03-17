package com.reyco.core.service;

import java.util.List;

import com.reyco.core.pojo.Video;

public interface VideoService {
	/**
	 * 分页
	 * @param categoryId
	 * @return
	 */
	public List<Video> searchPage(Integer pageNo,Integer status,String name,Integer categoryId,Integer accountId);
	/**
	 * 新增
	 * @param categoryId
	 * @param name
	 * @param recordPath
	 * @param hitQuantity
	 * @param desc
	 */
	//public void insertVideo(Integer categoryId,Integer vipId,Integer accountId,String name,String recordPath,Integer hitQuantity,Integer status,String desc);
	public void insertVideoUpdateCategory(Integer categoryId,Integer vipId,Integer accountId, String name, String recordPath, Integer hitQuantity,Integer status, String desc);
	/**
	 * 编辑
	 * @param id
	 * @param categoryId
	 * @param name
	 * @param status
	 * @param desc
	 */
	public void updateVideo(Integer id,Integer categoryId,String name,Integer hitQuantity,Integer status,String desc);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Video searchById(Integer id);
	
	/**
	 * 查询每个分类的N条数据
	 * @param count
	 * @return
	 */
	public List<Video> searchByCategoryIdGroup(Integer count);
	/**
	 * 查询数量
	 * @param status
	 * @param categoryId
	 * @param accountId
	 * @return
	 */
	public Integer searchCount(Integer status,Integer categoryId,Integer accountId);
}
