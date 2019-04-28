package hs.map;

import java.util.LinkedList;
/**
* �Զ���ʵ��Map�Ĺ��ܣ�
* �ݲ�������
* Map����ż�ֵ�ԣ�ͨ���������Ҷ�Ӧ��ֵ!
* �������˲�ѯЧ��
* @author ���ĺ�
*/
public class MyMap01 {
	LinkedList[] arr = new LinkedList[666];  //Map�ĵײ�ṹ������+����
	int size;
	public void put(Object key ,Object value){
		MyEntry e = new MyEntry(key, value);
		
		int hash =key.hashCode();
		hash=hash>0?hash:-hash;
		
		int a = hash%arr.length;		
		if(arr[a]==null){
			LinkedList list = new LinkedList();
			arr[a]=list;
			list.add(e);
		}else{
			//�����ֵ�ظ��Ľ��
			LinkedList list = arr[a];
			for(int i=0;i<list.size();i++){
				MyEntry e1 =(MyEntry)list.get(i);
				if(e1.key.equals(key)){
					 e1.value=value;
					 return;
				}
			}
			arr[a].add(e);
		}
	}
	public Object get(Object key){	
		int a = key.hashCode()%arr.length;
		if(arr[a]!=null){
			LinkedList list = arr[a];
			for(int i=0;i<list.size();i++){
				MyEntry e =(MyEntry)list.get(i);
				if(e.key.equals(key)){
					return e.value;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		MyMap01 map = new  MyMap01();
		map.put("a", "aaa");
		map.put("a", "bbb");
		System.out.println(map.get("a"));;
	}
	
}
