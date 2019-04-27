package com.reyco.core.test;

import java.util.ArrayList;
import java.util.List;

import com.reyco.core.entity.Base;

public class App {
	public static void main(String[] args) {
		List<Base> list = new ArrayList<Base>();
		for (int i=0;i<10;i++) {
			Base base = new Base("name"+i,"password"+i);
			list.add(base);
		}
		//共同的资源
		Movic m=new Movic();
		Player p=new Player(m,list);
		Watcher w=new Watcher(m);
		Thread t=new Thread(p);
		Thread t2=new Thread(w);
		t.start();
		t2.start();
	}
}
