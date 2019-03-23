package com.reyco.core.service;

import java.util.List;

import org.apache.solr.common.SolrInputDocument;

import com.reyco.core.pojo.Video;

public interface SolrService<T> {
	/**
	 * 将Video对象封装SolrInputDocument
	 * @param t
	 * @return
	 */
	SolrInputDocument getSolrInputDocumentByVideo(T t);
	/**
	 * 将Video对象新增到Solr
	 * @param doc
	 */
	void insertVideoToSolr(T t);
	/**
	 * 将Video对象放入list
	 * @param t
	 * @return
	 */
	List<T> addVideoToList(T t);
	/**
	 * 将list对象新增到Solr
	 * @param list
	 */
	void insertListToSolr(List<T> list);
	/**
	 * 初始化
	 * @param t
	 */
	void initSolr(List<T> t);
	
	void updateVideoSolr(T t);
	
	
}
