package hs.command;
/**
 * ��������   �ӿ�
 * @author Administrator
 */
public interface Command {
	void excute();
}


/**
 * ��������
 * 		ӵ����������ִ���ߵ�����
 * @author Administrator
 */
class ConcreteCommand implements Command{
	private Receiver receiver;	
	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}
	@Override
	public void excute() {
		//����������ִ��ǰ��󣬿���ִ����Ӧ�Ĵ���
		//......
		receiver.action();
	}	
}