package hs.chainOfResp;
/**
 * ������ģʽ -----�����޸Ĵ���  �Ϳ��������Ӧ������ 
 *  	��չ��ǿ
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		Leader a=new Director(":����,");
		Leader b=new Manager(":����,");
		Leader c=new GeneralManager(":����,");
		//�������ϵĶ����ϵ
		a.setNextLeader(b);
		b.setNextLeader(c);
		//��ʼ��ٲ���
		LeaveRequest req=new LeaveRequest("Tom",15,"����");
		a.HandleReques(req);
	}
}
