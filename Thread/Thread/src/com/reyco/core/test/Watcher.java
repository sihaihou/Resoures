package com.reyco.core.test;
//消费者
public class Watcher implements Runnable{
	private Movic m;
	public Watcher(Movic m) {
		super();
		this.m = m;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			m.watch();	
		}		
	}	
}
