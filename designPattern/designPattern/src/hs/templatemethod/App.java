package hs.templatemethod;
/**
 * ģ�巽��ģʽ
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		BankTempLateMethod b1=new BankTempLateMethod(){
			@Override
			public void transact() {
				System.out.println("����ȡ��ҵ�񡣡�������");
			}		
		};
		b1.process();
		System.out.println("===============");
		BankTempLateMethod b2=new BankTempLateMethod(){
			@Override
			public void transact() {
				System.out.println("����ת��ҵ�񡣡�������");
			}		
		};
		b2.process();
	}
}
