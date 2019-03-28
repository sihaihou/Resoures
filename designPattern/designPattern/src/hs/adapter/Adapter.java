package hs.adapter;
/**
 * 适配器(相当于USB和ps/2转换器)
 * @author Administrator
 */
public class Adapter extends Adaptee implements Target{
	@Override
	public void handleReq() {
		super.request();
	}	
}
