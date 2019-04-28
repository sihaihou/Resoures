package hs.map;

import java.util.LinkedList;
/**
* 自定义实现Map的功能！
* 暂不完美！
* Map：存放键值对，通过键对象找对应的值!
* 大大提高了查询效率
* @author 侯四海
*/
public class MyMap01 {
	LinkedList[] arr = new LinkedList[666];  //Map的底层结构：数组+链表
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
			//处理键值重复的解决
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
