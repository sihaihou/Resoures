package com.reyco.core.util;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

public interface ISolr<T> {
	/**
	 * solr分页搜索
	 * @param name 查询字符
	 * @param pageNo 第几页
	 * @return
	 * @throws SolrServerException
	 * @throws IOException
	 */
	List<T> searchPage(String name,Integer pageNo) throws SolrServerException, IOException;
	
}
