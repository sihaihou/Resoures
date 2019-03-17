package com.reyco.solr.test;

import java.io.IOException;

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
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	/**
	 * 地址
	 */
	private final static String URL = "http://192.168.2.107:8983/solr";
	/**
	 * 地址+核心
	 */
	private final static String URL_CORE = "http://192.168.2.107:8983/solr/solr";
	/**
	 * 核心
	 */
	private final static String CORE_NAME = "solr";

	public static void main(String[] args) throws SolrServerException, IOException {
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("spring-mvc.xml");
		application.start();
		System.out.println("springmvc start...");
		System.out.println("-------------------------------------------------------------------");
		testAdd("1001","name1001");
		testUpdate("1001","1002");
		testQuery("id:1001");
	    testDelete("1001");
		testQuery("id:1001");
	}

	/**
	 * 新增1
	 */
	public static void testAdd(String id,String name) {
		SolrClient client = new HttpSolrClient.Builder(URL_CORE).build();
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", "1001");
		doc.addField("name", "name1001");
		try {
			client.add(doc);
			client.commit();
			System.out.println("add success...");
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新
	 */
	public static void testUpdate(String id,String name) {
		SolrClient client = new HttpSolrClient.Builder(URL_CORE).build();
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", id);
		doc.addField("name", name);
		UpdateRequest request = new UpdateRequest();
		request.setAction(ACTION.COMMIT, false, false);
		request.add(doc);
		try {
			UpdateResponse resp = request.process(client);
			System.out.println(resp);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除
	 */
	public static void testDelete(String id) {
		SolrClient client = new HttpSolrClient.Builder(URL_CORE).build();
		try {
			client.deleteById(id);
			client.commit();
			System.out.println("delete success...");
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询
	 * 
	 * @throws SolrServerException
	 * @throws IOException
	 */
	public static void testQuery(String id) throws SolrServerException, IOException {
		SolrClient client = new HttpSolrClient.Builder(URL_CORE).build();
		SolrQuery query = new SolrQuery();
		query.set("q", id);
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
