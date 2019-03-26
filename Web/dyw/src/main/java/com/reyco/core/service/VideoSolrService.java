package com.reyco.core.service;

import java.util.List;
/**
 * Video Solr
 * @author reyco
 *
 * @param <T>
 */
public interface VideoSolrService<T> extends ISolrService<T>{
	/**
	 * 将Video对象放入list
	 * @param t
	 * @return
	 */
	List<T> addVideoToList(T t);
	
}
