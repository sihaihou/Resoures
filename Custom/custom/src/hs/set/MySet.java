package hs.set;

import java.sql.Connection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/**
 * �Զ����HashSet
 * @author ���ĺ�
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
		//Set�Ĳ����ظ�����������Map������Ĳ����ظ���
		 map.put(obj, PRESENT);
	 }	 
	 /**
	  * ����
	  * @param args
	  */
	 public static void main(String[] args) {
		Set s= new HashSet();
		s.add("hssak");
		//s.add("hssak");
		System.out.println(s.size());
	}
}
