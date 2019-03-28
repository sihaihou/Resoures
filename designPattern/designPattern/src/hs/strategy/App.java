package hs.strategy;

public class App {
	public static void main(String[] args) {
		Strategy st=new OldCustomermanyStrategy();
		Context ct=new Context(st);
		ct.PrintPrice(999);
	}
}
