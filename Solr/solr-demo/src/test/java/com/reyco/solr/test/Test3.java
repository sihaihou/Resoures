package com.reyco.solr.test;

import java.io.IOException;
import java.util.Random;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.AbstractUpdateRequest.ACTION;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
	/**
	 * 地址
	 */
	private final static String URL = "http://192.168.2.107:8080/solr";

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("spring-mvc.xml");
		application.start();
		System.out.println("springmvc start...");
		System.out.println("-------------------------------------------------------------------");
		//testAdd();
		//testQuery1();
		testQuery2();
	}

	/**
	 * 新增1
	 * @throws IOException 
	 * @throws SolrServerException 
	 */
	public static void testAdd() throws Exception {
		SolrClient client = new HttpSolrClient.Builder(URL).build();
		Random r = new Random();
		for(int i=1;i<=20;i++) {
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", i);
			doc.addField("name", "手机"+i);
			doc.addField("price", r.nextInt(10));
			client.add(doc);
		}
		for(int i=21;i<=40;i++) {
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", i);
			doc.addField("name", "电脑"+i);
			doc.addField("price",r.nextInt(10));
			client.add(doc);
		}
		client.commit();
		System.out.println("add success...");
	}


	/**
	 * 查询
	 * 
	 * @throws SolrServerException
	 * @throws IOException
	 */
	public static void testQuery1() throws SolrServerException, IOException {
		SolrClient client = new HttpSolrClient.Builder(URL).build();
		ModifiableSolrParams params = new ModifiableSolrParams();
		params.set("q", "*:*");
		//设置开始
		params.set("start", 0);
		//设置数据大小
		params.set("rows", 20);
		//设置排序
		params.set("sort", "price desc");
		QueryResponse response = client.query(params);
		SolrDocumentList results = response.getResults();
		if (results.size() < 1) {
			System.out.println("not nothing...");
		}
		for (SolrDocument solrDocument : results) {
			System.out.println("solrDocument===" + solrDocument);
		}
	}
	/**
	 * 查询
	 * 
	 * @throws SolrServerException
	 * @throws IOException
	 */
	public static void testQuery2() throws SolrServerException, IOException {
		SolrClient client = new HttpSolrClient.Builder(URL).build();
		SolrQuery query = new SolrQuery();
		//并且关系
		//query.set("q", "name:手 AND　price:7");
		//或者关系
		//query.set("q", "name:手 or price:7");
		//name包含手但price不包含7
		//query.set("q", "name:手  NOT price:7");
		//[4 TO 6] 4到6,包含4和6
		//query.set("q", "name:手  AND price:[4 TO 6]");
		//[4 TO 6] 4到6,不包含4和6
		//query.set("q", "name:手  AND price:{4 TO 6}");
		//
		query.set("q", "price:[4 TO 6]");
		query.addFilterQuery("name:电脑");
		
		//
		query.setHighlight(true);  //开启高亮组件
		query.addHighlightField("name"); //高亮字段
		query.setHighlightSimplePre("<font color='red'>");//标记，高亮关键字前缀
		query.setHighlightSimplePost("</font>");//标记，高亮关键字后缀
		query.setHighlightSnippets(1); // 结果分片数，默认1
		query.setHighlightFragsize(100); //每个分片最低长度，默认100
		query.setFacet(true).setFacetMinCount(1).setFacetLimit(5).addFacetField("name");
		
		query.set("start", 0);
		query.set("rows", 20);
		query.set("sort", "price desc");
		QueryResponse response = client.query(query);
		SolrDocumentList results = response.getResults();
		if (results.size() < 1) {
			System.out.println("not nothing...");
		}
		for (SolrDocument solrDocument : results) {
			System.out.println("solrDocument===" + solrDocument);
		}
	}
}
