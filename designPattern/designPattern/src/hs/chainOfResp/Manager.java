package hs.chainOfResp;
/**
 * ����
 * @author Administrator
 */
public class Manager extends Leader{
	public Manager(String name) {
		super(name);
	}
	/**
	 * ��ǰ��������
	 */
	@Override
	public void HandleReques(LeaveRequest request) {
		if(request.getLeaveDays()<10){
			System.out.println("Ա��"+request.getName()+"��٣�������"+request.getLeaveDays()+",����:"+request.getReason());
			System.out.println("����"+this.name+"����"+request.getName()+"�������ͨ����");
		}else{
			if(null!=this.nextLeader){
				this.nextLeader.HandleReques(request);
			}
		}
	}	
}
