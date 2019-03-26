package com.reyco.core.service;

import java.util.List;
import java.util.Map;

import org.apache.solr.common.SolrInputDocument;

/**
 * Solr 顶级接口
 * @author reyco
 *
 * @param <T>
 */
public interface ISolrService<T> {
	/**
	 * 初始化
	 * @param t
	 */
	void initSolr(List<T> t);
	/**
	 * 将t对象封装SolrInputDocument
	 * @param t
	 * @return
	 */
	SolrInputDocument getSolrInputDocument(T t);
	/**
	 * 批量新增数据到Solr
	 * @param t
	 */
	void BatchInsertSolr(List<T> list);
	/**
	 * 更新Solr数据
	 * @param t
	 */
	void updateSolr(T t);
	/**
	 *    Solr分页查询
	 * @param pageNo    第几页
	 * @param pageSize  每页大小 
	 * @param keywords  关键字
	 * @return
	 */
	Map searchSolr(Integer pageNo,Integer pageSize,String keywords);
}
