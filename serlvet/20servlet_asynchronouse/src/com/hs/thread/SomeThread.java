package com.hs.thread;

import java.io.PrintWriter;
/**
 * 子线程
 * @author Administrator
 *
 */
public class SomeThread implements Runnable {
	private PrintWriter out;
	public SomeThread(PrintWriter out) {
		super();
		this.out = out;
	}
	@Override
	public void run() {
		out.println("====子线程开始====");
		int sum=0;
		for(int i=0;i<10;i++) {
			System.err.println("---------"+i);
			sum += i;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		out.println("====子线程结束====");
	}

}
