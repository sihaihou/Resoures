package hs.state;
/**
 * �������
 * 		����״̬������
 * @author Administrator
 */
public class HomeContext {
	private State state;
	/**
	 * ����״̬����
	 * @param state
	 */
	public void setState(State state){
		System.out.println("�޸�״̬����");
		this.state=state;
		state.handle();		
	}
}
