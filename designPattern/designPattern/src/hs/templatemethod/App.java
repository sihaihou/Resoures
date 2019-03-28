package hs.templatemethod;
/**
 * 模板方法模式
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		BankTempLateMethod b1=new BankTempLateMethod(){
			@Override
			public void transact() {
				System.out.println("办理取款业务。。。。。");
			}		
		};
		b1.process();
		System.out.println("===============");
		BankTempLateMethod b2=new BankTempLateMethod(){
			@Override
			public void transact() {
				System.out.println("办理转账业务。。。。。");
			}		
		};
		b2.process();
	}
}
