package hs.chainOfResp;
/**
 * ����
 * @author Administrator
 */
public class Director extends Leader{
	public Director(String name) {
		super(name);
	}
	@Override
	public void HandleReques(LeaveRequest request) {
		if(request.getLeaveDays()<3){
			System.out.println("Ա��"+request.getName()+"��٣�������"+request.getLeaveDays()+",����:"+request.getReason());
			System.out.println("����"+this.name+"����"+request.getName()+"�������ͨ����");
		}else{
			if(null!=this.nextLeader){
				this.nextLeader.HandleReques(request);
			}
		}
	}	
}
