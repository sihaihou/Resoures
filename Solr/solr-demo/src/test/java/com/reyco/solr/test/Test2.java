package com.reyco.solr.test;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 直接传java对象
 *   1,对象要加注解
 *           @Field("user_name")
 *           private String name;
 *   2,核心配置文件里要加属性配置：
 *         <!-- 自定义-->
 *         <field name="user_name" type="text_general" indexed="true" stored="true" multiValued="false" />
 *         <field name="user_password" type="string" indexed="true" stored="true" multiValued="false" />
 *   3,代码操作传对象
 *       
 *        
 * @author reyco
 *
 */
public class Test2 {
	/**
	 * 地址
	 */
	private final static String URL = "http://192.168.2.107:8080/solr";

	public static void main(String[] args) throws SolrServerException, IOException {
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("spring-mvc.xml");
		application.start();
		System.out.println("springmvc start...");
		System.out.println("-------------------------------------------------------------------");
		testAdd();
		testQuery("user_name:张");
		//testDelete("user_name:张");
		testQuery("user_name:张");
	}

	/**
	 * 新增1
	 */
	public static void testAdd() {
		SolrClient client = new HttpSolrClient.Builder(URL).build();
		User user1 = new User();
		user1.setId("id1");
		user1.setName("张三");
		user1.setPassword("password1");
		User user2 = new User();
		user2.setId("id2");
		user2.setName("张四");
		user2.setPassword("password2");
		try {
			client.addBean(user1);
			client.addBean(user2);
			client.commit();
			System.out.println("add success...");
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
		SolrClient client = new HttpSolrClient.Builder(URL).build();
		try {
			client.deleteByQuery(id);
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
		SolrClient client = new HttpSolrClient.Builder(URL).build();
		SolrQuery query = new SolrQuery();
		query.set("q", id);
		QueryResponse response = client.query(query);
		SolrDocumentList results = response.getResults();
		if (results.size() < 1) {
			System.out.println("not nothing...");
		}
		for (SolrDocument solrDocument : results) {
			System.out.println("solrDocument===" + solrDocument);
			/**
			 * 转java对象
			 */
			System.out.println("user=="+client.getBinder().getBean(User.class, solrDocument));
		}
	}
}
