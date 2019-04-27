package com.reyco.core.App;

import java.util.ArrayList;
import java.util.List;

import com.reyco.core.entity.Base;
import com.reyco.core.thread.Bases;
import com.reyco.core.thread.Shengchan;
import com.reyco.core.thread.XiaoFei;

public class App {
	public static void main(String[] args) {
		List<Base> list = getList();
		for (Base base : list) {
			Bases bases = new Bases();
			Shengchan shengchan = new Shengchan(base,bases);
			XiaoFei xiaoFei = new XiaoFei(bases);
			Thread t=new Thread(shengchan);
			Thread t2=new Thread(xiaoFei);
			t.start();
			t2.start();
		}
	}
	private static List<Base> getList(){
		List<Base> list = new ArrayList<Base>();
		for(int i=0;i<10;i++) {
			Base base = new Base("name"+i,i+"23456");
			list.add(base);
		}
		return list;
	}
}
