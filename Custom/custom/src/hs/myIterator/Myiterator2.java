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
 *
 */
public class Myiterator2 {
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
		private class MyIter{
			//��������ָ�롢�α�
			public int cours =-1;
			//�ж��Ƿ������һ��
			boolean hashNext(){
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
				System.arraycopy(elem, cours+1, elem,cours , /*this.*/size-(cours+1));
				//ʵ�ʴ�С-1
				/*this.*/size--;
				//����
				/*this.*/cours--;
			}
		}
		public MyIter Myiter(){
			return new MyIter();
		}
		public static void main(String[] args) {		
			Myiterator2 d= new Myiterator2();			
			d.add("���Ԫ��");
			d.add("���Ԫ��2");
			d.add("���Ԫ��3");			
			MyIter it = d.Myiter();
			while(it.hashNext()){	//���жϣ����ȡ
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
