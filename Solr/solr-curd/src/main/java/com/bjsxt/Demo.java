package com.bjsxt;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;


/**
 * 增加删除修改都需要提交事务
 * @author Administrator
 *
 */
public class Demo {
	
	/**
	 * 新增5
	 * @throws SolrServerException
	 * @throws IOException
	 */
	@Test
	public void testInsert() throws SolrServerException, IOException{
		SolrClient client = new HttpSolrClient("http://192.168.2.107:9080/solr");
		
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", "005");
		doc.addField("user_name", "username1");
		doc.addField("user_password", "password1");
		
		client.add(doc);
		client.commit();
	}
	@Test
	public void testDelete() throws SolrServerException, IOException{
		SolrClient client = new HttpSolrClient("http://192.168.2.107:9080/solr");
		client.deleteById("005");
		client.commit();
	}
	@Test
	public void testQuery() throws SolrServerException, IOException{
		SolrClient client = new HttpSolrClient("http://192.168.2.107:9080/solr");
		
		//可视化界面左侧条件
		SolrQuery params = new SolrQuery();
		//设置q
		params.setQuery("user_name:*");
		//设置分页
		//从第几条开始查询,从0开始
		params.setStart(0);
		//查询几个
		params.setRows(10);
		
		//启动高亮
		params.setHighlight(true);
		//设置高亮列
		params.addHighlightField("user_name");
		//设置前缀
		params.setHighlightSimplePre("<span style='color:red;'>");
		//设置后缀
		params.setHighlightSimplePost("</span>");
		
		//相当于点击查询按钮, 本质,向solr web服务器发送请求,并接收响应. query对象里面包含了返回json数据
		QueryResponse response = client.query(params);
		
		Map<String, Map<String, List<String>>> hh = response.getHighlighting();
		
		
		//取出docs{}
		SolrDocumentList solrList = response.getResults();
		
		for (SolrDocument doc : solrList) {
			System.out.println(doc.getFieldValue("id"));
			System.out.println("未高亮:"+doc.getFieldValue("user_name"));
			Map<String, List<String>> map = hh.get(doc.getFieldValue("id"));
			System.out.println(map);
			//list可能为null
			List<String> list = map.get("user_name");
			System.out.println(list);
			if(list!=null&&list.size()>0){
				System.out.println("高亮:"+list.get(0));
			}else{
				System.out.println("没有高亮内容");
			}
			System.out.println(doc.getFieldValue("user_password"));
		}
		
	}
	
}
