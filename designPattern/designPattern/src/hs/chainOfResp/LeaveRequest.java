package hs.chainOfResp;
/**
 * ��װ��ٵĻ�����Ϣ
 * @author Administrator
 */
public class LeaveRequest {
	/**
	 * ��ٶ���
	 */
	private String name; 
	/**
	 * ��ٶ��ʱ��
	 */
	private int LeaveDays;
	/**
	 * �������
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
