package hs.iterator;
/**
 * �Զ���  �������ӿ�
 * @author Administrator
 */
public interface MyIterator {
	/**
	 * ���α�ָ���һ��Ԫ��
	 */
	void first(); 
	/**
	 * ���α�ָ����һһ��Ԫ��
	 */
	void next();	
	/**
	 * �Ƿ������һһ��Ԫ��
	 * @return
	 */
	boolean HasNext();  
	/**
	 * �Ƿ��ǵ�һ��Ԫ��
	 * @return
	 */
	boolean isfirst();	
	/**
	 * �Ƿ������һ��Ԫ��
	 * @return
	 */
	boolean isLast();		
	/**
	 * ��ȡ��ǰ�α�ָ��Ķ���
	 * @return
	 */
	Object getCurrentObj();	
}
