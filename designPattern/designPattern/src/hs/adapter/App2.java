package hs.adapter;

public class App2 {
	public void test(Target t){
		t.handleReq();
	}
	public static void main(String[] args) {
		App2 a=new App2();
		Adaptee adaptee=new Adaptee();
		Target t=new Adapter2(adaptee);
		t.handleReq();
	}	
}