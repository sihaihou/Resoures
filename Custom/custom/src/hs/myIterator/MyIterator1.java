package hs.myIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/**
 * Ŀ�ģ�����������ԭ��
 * ʹ�����ڲ��ࡣ������һ���������Դ����������������
 * ʹ���ڲ��ࡣ������ʵ�ֵ�����ԭ��
 * ����ĩβ���Ԫ�صķ���
 * @author Administrator
 */
public class MyIterator1  {
		//����
		public String[] elem = {"a","b","c"};
        //�����С
		public int size=elem.length;		
		public int size(){
			return size;
		}
		public void add(String ele){
			if(size==elem.length){//��������....>����
				elem=Arrays.copyOf(elem ,elem.length*2);
			}
			elem[size]=ele; // �����м���Ԫ��
			size++;			//ʵ�ʴ�С+1
		}
		public MyIter iterator1(){
			return  new MyIter();
		}	
		private class MyIter implements Iterator{
			//��������ָ�롢�α�
			public int cours =-1;
			//�ж��Ƿ������һ��				
			@Override
			public boolean hasNext() {
				return cours+1<size;
			}		
			//��ȡ��һ��
			public String next(){
				cours++;
				return elem[cours];
			}	
			//ɾ����һ��
			public void remove(){
				//�ƶ�����Ԫ��
				System.arraycopy(elem, cours+1, elem,cours , size-(cours+1));
				//ʵ�ʴ�С-1
				size--;
				//����
				cours--;
			}				
		}		
		public static void main(String[] args) {		
			MyIterator1 d= new MyIterator1();				
			d.add("���Ԫ��");
			d.add("���Ԫ��2");
			d.add("���Ԫ��3");			
			MyIter it = d.iterator1();
			while(it.hasNext()){	//���жϣ����ȡ
				System.out.println(it.next());
				it.remove();
			}
//			System.out.println("$$$$$$$$$$$$$");
//			it = d.Myiter();
//			while(it.hashNext()){   //���жϣ����ȡ
//				System.out.println(it.next());
//				it.remove();
//			}			
			List list = new ArrayList();
			list.add("a");
			list.add("a");
			list.add("a");
			for(Object obj :list){
			System.out.println(obj);
			}
		}
}
