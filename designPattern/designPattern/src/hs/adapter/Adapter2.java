package hs.adapter;
/**
 * 类适配器(相当于转换器)
 * (对象适配器,使用了组合的方式跟被适配对象整合)
 * @author Administrator
 */
public class Adapter2 implements Target{
	private Adaptee apadtee;
	
	public Adapter2(Adaptee apadtee) {
		this.apadtee = apadtee;
	}
	@Override
	public void handleReq() {
		apadtee.request();
	}
	
}
