package hs.mediator;
/**
 * 抽象部门   接口
 * @author Administrator
 */
public interface Department {
	/**
	 * 做自己的事
	 */
	void selfAction();
	/**
	 * 向总经理发出申请
	 */
	void outAction();	
}



/**
 * 具体部门---研发部
 * @author Administrator
 */
class Development implements Department{
	/**
	 * 持有中介者的引用
	 */
	private Mediator m;  
	public Development(Mediator m) {
		this.m = m;
		m.register("Development",this);

	}
	@Override
	public void selfAction() {
		System.out.println("研究开发。。。。。");
	}
	@Override
	public void outAction() {
		System.out.println("需要资金支持。。。。。");	
		//假设调财务部
		m.command("Finacial");
	}
}
/**
 * 具体部门---财务部
 * @author Administrator
 */
class Finacial implements Department{
	 /**
	  * 持有中介者的引用
	  */
	private Mediator m; 
	public Finacial(Mediator m) {
		this.m = m;
		m.register("Finacial",this);
	}
	@Override
	public void selfAction() {
		System.out.println("数钱。。。。。");
	}
	@Override
	public void outAction() {
		System.out.println("钱太多了，怎么办？。。。。。");
		m.command("Development");
		m.command("Market");
	}
}
/**
 * 具体部门---市场部
 * @author Administrator
 */
class Market implements Department{
	/**
	 * 持有中介者的引用
	 */
	private Mediator m;  
	public Market(Mediator m) {
		this.m = m;
		m.register("Market",this);
	}
	@Override
	public void selfAction() {
		System.out.println("接项目。。。。。");
	}
	@Override
	public void outAction() {
		System.out.println("汇报工作，需要资金支持。。。。。");
		m.command("Finacial");
	}
}