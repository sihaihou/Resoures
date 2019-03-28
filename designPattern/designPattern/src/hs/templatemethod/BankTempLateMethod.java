package hs.templatemethod;

public abstract class BankTempLateMethod {
	//具体方法
	public void takeNumber(){
		System.out.println("排队取号。。。。。");
	}
	public abstract void transact(); //办理具体的业务     钩子方法
	
	public void evaluate(){
		System.out.println("反馈评分。。。。。");
	}
	public final void process(){
		takeNumber();
		transact();
		evaluate();
	}
}
