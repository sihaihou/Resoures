package hs.adapter;

/**
 * �൱�ڵ���(ֻ��USB�ӿ�)
 * @author Administrator
 */
public class App {
	public void test(Target t){
		t.handleReq();
	}
	public static void main(String[] args) {
		App a=new App();
		Adaptee adaptee=new Adaptee();
		Target t=new Adapter();
		t.handleReq();
	}	
}
