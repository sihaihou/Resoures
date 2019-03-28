package hs.chainOfResp;
/**
 * ������	����������
 * @author Administrator
 */
public abstract class Leader {
	/**
	 * ��ǰ��������������
	 */
	protected String name;
	/**
	 * �������ϵĺ�̶���
	 */
	protected Leader nextLeader; 
	public Leader(String name) {
		super();
		this.name=name;
	}
	/**
	 * �趨�������ϵĺ�̶���
	 * @param nextLeader
	 */
	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}
	/**
	 * ��������ĺ��ĵ�ҵ����󷽷�
	 * @param request
	 */
	public abstract void HandleReques(LeaveRequest request);
}
