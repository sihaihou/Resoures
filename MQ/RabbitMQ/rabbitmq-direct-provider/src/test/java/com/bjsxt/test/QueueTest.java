package com.bjsxt.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bjsxt.Sender;
import com.bjsxt.SpringbootServerApplication;

/**
 * 消息队列测试类
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringbootServerApplication.class)
public class QueueTest {

	@Autowired
	private Sender sender;
	
	/*
	 * 测试消息队列
	 */
	@Test
	public void test1()throws Exception{
		int i=0;
		while(true){
			Thread.sleep(1000L);
			this.sender.send("Hello RabbitMQ..."+i++);
		}
	}
	/*
	 * 测试消息队列
	 */
	@Test
	public void test2(){
		this.sender.send("Hello RabbitMQ...");
	}
}
