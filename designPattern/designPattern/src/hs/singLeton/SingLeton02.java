package hs.singLeton;
/**
 * �������ģʽ       ȷ��һ����ֻ��һ������
 *	  ����ʽ--->�̰߳�ȫ,����Ч�ʲ��ߣ����ǣ�������ʱ����
 *	  1��������˽�л��������ⲿֱ�Ӵ�������
 *	  2������һ��˽�еľ�̬����
 *    3������һ������Ĺ����ľ�̬���������ʸñ������������û�ж��󣬴����ö��� 
 * @author ���ĺ�
 */
public class SingLeton02 {
	/**
	 * ���ʼ��ʱ������ʼ���������(��ʱ���أ������õ�ʱ���ڴ���)
	 */
	private static SingLeton02 instance;
	/**
	 * ˽�й�����ֻ���Լ�ʹ��
	 */
	private SingLeton02() {
		
	}
	/**
	 * ����ͬ����Ч�ʵ�
	 * @return
	 */
	public static synchronized SingLeton02 getInstance(){
		if(null==instance){
			instance =new SingLeton02();
		}
		return instance;
	}
}
