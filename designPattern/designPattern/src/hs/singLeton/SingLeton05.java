 package hs.singLeton;

import java.io.Serializable;

/**
 * �������ģʽ     
 *	  ����ʽ--->(��η�ֹ����ͷ����л�©��)
 * @author Administrator
 */
public class SingLeton05 implements Serializable{
	/**
	 * ���ʼ��ʱ������ʼ���������(��ʱ���أ������õ�ʱ���ڴ���)
	 */
	private static SingLeton05 instance;	
	private SingLeton05()  {
		//��ֹ����©��������ж����ˣ��ٴε��ã����׳�RuntimeException�쳣.
		if(null!=instance){
			throw new RuntimeException();
		}	
	}
	/**
	 * ����ͬ����Ч�ʵ�
	 * @return
	 */
	public static synchronized SingLeton05 getInstance(){
		if(null==instance){
			instance =new SingLeton05();
		}
		return instance;
	}
	
	/**
	 * ��ֹ�����л�©��(�����л������������readResolve��������ֱ�ӷ��ش˷���ָ���Ķ��󣬶�����Ҫ������������)
	 * @return
	 * @throws Exception
	 */
	public Object readResolve()throws Exception{
		return instance;
	}
}
