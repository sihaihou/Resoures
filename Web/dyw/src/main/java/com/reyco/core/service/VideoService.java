package com.reyco.core.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;

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
	/**
	 * solr数据初始化
	 * @throws Exception
	 */
	public void Initialization()throws Exception;
	
	/**
	 * solr分页搜索
	 * @param name 查询字符
	 * @param pageNo 第几页
	 * @return
	 * @throws SolrServerException
	 * @throws IOException
	 */
	Map<String,Object> searchPage(Integer pageNo,Integer pageSize,String name) throws SolrServerException, IOException;
	
}
