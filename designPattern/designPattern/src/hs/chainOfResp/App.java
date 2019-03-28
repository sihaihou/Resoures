package hs.chainOfResp;
/**
 * 责任链模式 -----不用修改代码  就可以添加相应的子类 
 *  	扩展性强
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		Leader a=new Director(":张三,");
		Leader b=new Manager(":李四,");
		Leader c=new GeneralManager(":王五,");
		//责任链上的对象关系
		a.setNextLeader(b);
		b.setNextLeader(c);
		//开始请假操作
		LeaveRequest req=new LeaveRequest("Tom",15,"相亲");
		a.HandleReques(req);
	}
}
