package hs.set;

import java.sql.Connection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/**
 * 自定义的HashSet
 * @author 侯四海
 */
public class MySet {
	 private HashMap map;
	 private static final Object PRESENT = new Object();
	 public MySet(){
		 map = new HashMap();
	 }
	 public int size(){
		 return map.size();
	 }
	 public void add(Object obj){
		//Set的不可重复就是利用了Map键对象的不可重复！
		 map.put(obj, PRESENT);
	 }	 
	 /**
	  * 测试
	  * @param args
	  */
	 public static void main(String[] args) {
		Set s= new HashSet();
		s.add("hssak");
		//s.add("hssak");
		System.out.println(s.size());
	}
}
