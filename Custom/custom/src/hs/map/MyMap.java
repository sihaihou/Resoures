package hs.map;

import java.util.HashMap;
import java.util.Map;
/**
 * �Զ���ʵ��Map�Ĺ��ܣ�
 * �ݲ�������
 * Map����ż�ֵ�ԣ�ͨ���������Ҷ�Ӧ��ֵ!
 * @author ���ĺ�
 */
public class MyMap {
	MyEntry[] arr = new MyEntry[666];
	public int size;
	public int size(){
		return size;
	}
   /**
    * ��Ӷ���
    * @param key
    * @param value
    */
	public void put(Object key,Object value){
		MyEntry e = new MyEntry(key,value);
		//������ظ��Ĵ���
		for(int i=0;i<size;i++){
			if(arr[i].key.equals(key)){
				arr[i].value=value;
				return ;
			}
		}
		arr[size++]=e;
	}
	/**
	 * ��ȡ����
	 * @param Key
	 * @return Object
 	 */
	public Object get(Object Key){
		for(int i=0;i<arr.length;i++){
			if( arr[i].key.equals(Key)){			  
				return arr[i].value;
			}
		}
		return null;
	}	
	/**
	 * ����
	 * @param args
	 */
	public static void main(String[] args) {
	   MyMap m = new MyMap();
	   m.put(123, 214748);
	   m.put(123, 3994);
	   m.put(1, 214758);			
	   System.out.println(m.get(123));
	   System.out.println(m.size());
	}
}