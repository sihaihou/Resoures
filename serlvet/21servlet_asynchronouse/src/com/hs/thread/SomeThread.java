package com.hs.thread;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
/**
 * ���߳�
 * @author Administrator
 *
 */
public class SomeThread implements Runnable {
	private AsyncContext ac;;
	public SomeThread(AsyncContext ac) {
		this.ac = ac;
	}
	@Override
	public void run() {
		try {
			PrintWriter	out = ac.getResponse().getWriter();
			out.println("====���߳̿�ʼ====<br>");
			int sum=0;
			for(int i=1;i<10;i++) {
				System.err.println("---------"+i);
				sum += i;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			out.println("sum==="+sum+"<br>");
			out.println("====���߳̽���====<br>");
			//ac.complete();
			//ac.dispatch("/show.jsp");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
