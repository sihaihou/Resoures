package hs.state;
/**
 * ���󷿼�״̬ �ӿ�
 * @author Administrator
 *
 */
public interface State {
	void handle();
}

/**
 * ����״̬
 * @author Administrator
 */
class FreeState implements State{
	@Override
	public void handle() {
		System.out.println("���������,��Ԥ������������");
	}	
}
/**
 * Ԥ��״̬
 * @author Administrator
 */
class BookedState implements State{
	@Override
	public void handle() {
		System.out.println("������Ԥ������������");

	}	
}
/**
 * ��ס״̬
 * @author Administrator
 */
class CheckedInState implements State{
	@Override
	public void handle() {
		System.out.println("��������ס��������š���������");
	}	
}