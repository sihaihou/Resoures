package hs.map;

import java.util.HashMap;
import java.util.Map;
/**
 * 自定义实现Map的功能！
 * 暂不完美！
 * Map：存放键值对，通过键对象找对应的值!
 * @author 侯四海
 */
public class MyMap {
	MyEntry[] arr = new MyEntry[666];
	public int size;
	public int size(){
		return size;
	}
   /**
    * 添加对象
    * @param key
    * @param value
    */
	public void put(Object key,Object value){
		MyEntry e = new MyEntry(key,value);
		//解决键重复的处理
		for(int i=0;i<size;i++){
			if(arr[i].key.equals(key)){
				arr[i].value=value;
				return ;
			}
		}
		arr[size++]=e;
	}
	/**
	 * 获取对象
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
	 * 测试
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