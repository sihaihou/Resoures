package com.hs.thread;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * ×ÓÏß³Ì
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
		HttpServletRequest request = (HttpServletRequest) ac.getRequest();
		HttpSession session = request.getSession();
		int sum=0;
		for(int i=1;i<=10;i++) {
			System.err.println("---------"+i);
			sum += i;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		session.setAttribute("sum", sum);
	}

}
