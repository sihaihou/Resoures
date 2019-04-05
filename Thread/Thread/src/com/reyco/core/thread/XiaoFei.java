package com.reyco.core.thread;

public class XiaoFei implements Runnable{
	private Bases bases;
	@Override
	public void run() {
		bases.xiaoFei();
	}
	public XiaoFei() {
		// TODO Auto-generated constructor stub
	}
	public XiaoFei(Bases bases) {
		super();
		this.bases = bases;
	}
	public Bases getBases() {
		return bases;
	}
	public void setBases(Bases bases) {
		this.bases = bases;
	}

}
