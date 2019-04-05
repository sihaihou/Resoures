package com.hs.thread;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * 子线程
 * @author Administrator
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
		String msg = "注册失败，请重新注册！"; 
		if(sum == 55) {
			msg ="恭喜,注册成功！";
		}
		session.setAttribute("msg", msg);
	}

}
