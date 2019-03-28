package hs.strategy;
/**
 * 负责和具体的策略类交互
 * 这样的话，具体的算法和直接的客户端调用分离了，使得算法可以独立于客户端独立的变化
 * @author Administrator
 */
public class Context {
	private Strategy strategy;
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}
	/**
	 * 通过set方法注入
	 * @param strategy
	 */
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	public void PrintPrice(double s){
		System.out.println("你该报价:"+strategy.getPrice(s));
	}	
}
