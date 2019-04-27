package hs.strategy;
/**
 * ����;���Ĳ����ཻ��
 * �����Ļ���������㷨��ֱ�ӵĿͻ��˵��÷����ˣ�ʹ���㷨���Զ����ڿͻ��˶����ı仯
 * @author Administrator
 */
public class Context {
	private Strategy strategy;
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}
	/**
	 * ͨ��set����ע��
	 * @param strategy
	 */
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	public void PrintPrice(double s){
		System.out.println("��ñ���:"+strategy.getPrice(s));
	}	
}
