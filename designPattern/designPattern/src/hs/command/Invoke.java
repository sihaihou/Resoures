package hs.command;
/**
 * ����ĵ�����|������
 * @author Administrator
 */
public class Invoke {
	private Command command;
	public Invoke(Command command) {
		this.command = command;
	}
	/**
	 * ҵ�񷽷�    ���ڵ���������ķ���
	 */
	public void call(){
		//����������ִ��ǰ��󣬿���ִ����Ӧ�Ĵ���
		//......
		command.excute();
	}
}
