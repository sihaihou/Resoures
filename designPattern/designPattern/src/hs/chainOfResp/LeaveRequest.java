package hs.chainOfResp;
/**
 * 封装请假的基本信息
 * @author Administrator
 */
public class LeaveRequest {
	/**
	 * 请假对象
	 */
	private String name; 
	/**
	 * 请假多次时间
	 */
	private int LeaveDays;
	/**
	 * 请假理由
	 */
	private  String reason;	
	public LeaveRequest(String name, int leaveDays, String reason) {
		super();
		this.name = name;
		this.LeaveDays = leaveDays;
		this.reason = reason;
	}
	public String getName() {
		return name;
	}
	public int getLeaveDays() {
		return LeaveDays;
	}
	public String getReason() {
		return reason;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLeaveDay(int leaveDays) {
		LeaveDays = leaveDays;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
