package hs.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * �Զ���ۺ���
 * @author Administrator
 */
public class ConcreteMyAggregate {
	private List<Object> list =new ArrayList();
	/**
	 * ��Ӷ���
	 * @param obj
	 */
	public void addObject(Object obj){
		list.add(obj);
	}
	/**
	 * �Ƴ�����
	 * @param obj
	 */
	public void removeObject(Object obj){
		list.remove(obj);
	}	
	public List<Object> getList(){
		return list;		
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	/**
	 * ��ȡ����������
	 * @return
	 */
	public MyIterator CreateIterator(){
		return new ConcreteIterator();
	}
	
	
	
	/**
	 * ʹ���ڲ��ඨ�������������ֱ��ʹ���ⲿ�������
	 * @author Administrator
	 */
	private class ConcreteIterator implements MyIterator{
		 /**
		  * �����α�---���ڼ�¼����List����ʱ��λ��
		  */
		private int cursor; 
		/**
		 * ��ǰ�α�����
		 */
		@Override
		public void first() {
			cursor=0;
		}
		/**
		 * ��ȡ�����α����
		 */
		@Override
		public Object getCurrentObj() {
			return list.get(cursor);
		}	
		/**
		 * ���α�ָ����һ��Ԫ��
		 */
		@Override
		public void next() {
			if(cursor<list.size()){
				cursor++;
			}
		}
		/**
		 * �Ƿ������һ��Ԫ��
		 */
		@Override
		public boolean HasNext() {
			if(cursor<list.size()){
				return true;
			}
			return false;
		}
		/**
		 * �жϵ�ǰ�����Ƿ��һ��Ԫ��
		 */
		@Override
		public boolean isfirst() {
			return cursor==0?true:false;
		}
		/**
		 * �жϵ�ǰ�����Ƿ����һ��Ԫ��
		 */
		@Override
		public boolean isLast() {
			return cursor==(list.size()-1)?true:false;
		}
	} 
}
