package com.reyco.core.dao;

import java.util.List;
import java.util.Map;

import com.reyco.core.pojo.Video;

public interface VideoDao {
	/**
	 * 分页
	 * @param map
	 * @return
	 */
	@Deprecated
	public List<Video> searchPage(Map<String,Object> map);
	/**
	 * 分页
	 * @param video
	 * @return
	 */
	public List<Video> searchPage(Video video);
	/**
	 * 新增
	 * @param map
	 */
	@Deprecated
	public void insertVideo(Map<String,Object> map);
	/**
	 * 新增
	 * @param video
	 */
	public void insertVideo(Video video);
	/**
	 * 编辑
	 * @param map
	 */
	@Deprecated
	public void updateVideo(Map<String,Object> map);
	/**
	 * 编辑
	 * @param video
	 */
	public void updateVideo(Video video);
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
 	 * @param map
 	 * @return
 	 */
	@Deprecated
	public Integer searchCount(Map<String,Object> map);
	/**
	 * 编辑
	 * @param video
	 * @return
	 */
	public Integer searchCount(Video video);
	/**
	 * 查询所有
	 * @return
	 */
	public List<Video> searchAll();
	
}
