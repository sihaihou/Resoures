package hs.chainOfResp;
/**
 * �ܾ���
 * @author Administrator
 */
public class GeneralManager extends Leader{
	public GeneralManager(String name) {
		super(name);
	}
	@Override
	public void HandleReques(LeaveRequest request) {
		if(request.getLeaveDays()<30){
			System.out.println("Ա��"+request.getName()+"��٣�������"+request.getLeaveDays()+",����:"+request.getReason());
			System.out.println("�ܾ���"+this.name+"����"+request.getName()+"�������ͨ����");

		}else{
			System.out.println("���˿������ְ��������ͨ����");
		}
	}	
}
