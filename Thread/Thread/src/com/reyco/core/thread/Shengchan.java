package com.reyco.core.thread;

import com.reyco.core.entity.Base;

public class Shengchan implements Runnable{
	private Base base;
	private Bases bases;
	@Override
	public void run() {
		bases.shengChan(base);
	}
	public Shengchan() {
		super();
	}
	public Bases getBases() {
		return bases;
	}
	public void setBases(Bases bases) {
		this.bases = bases;
	}
	public Base getBase() {
		return base;
	}
	public void setBase(Base base) {
		this.base = base;
	}
	public Shengchan(Base base, Bases bases) {
		super();
		this.base = base;
		this.bases = bases;
	}
}
