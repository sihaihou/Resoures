package com.reyco.core.test;

import java.util.List;

import com.reyco.core.entity.Base;

//生产者
public class Player implements Runnable{
	private Movic m;
	private List<Base> list;
	public Player(Movic m, List<Base> list) {
		this.m = m;
		this.list = list;
	}
	@Override
	public void run() {
		for (Base base : list) {
			m.play(base);
		}
	}	
}
