package hs.chainOfResp;
/**
 * 抽象类	责任链对象
 * @author Administrator
 */
public abstract class Leader {
	/**
	 * 当前责任链对象名称
	 */
	protected String name;
	/**
	 * 责任链上的后继对象
	 */
	protected Leader nextLeader; 
	public Leader(String name) {
		super();
		this.name=name;
	}
	/**
	 * 设定责任链上的后继对象
	 * @param nextLeader
	 */
	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}
	/**
	 * 处理请求的核心的业务抽象方法
	 * @param request
	 */
	public abstract void HandleReques(LeaveRequest request);
}
