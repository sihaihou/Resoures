package hs.myIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 目的；理解迭代器的原理
 * 使用了内部类。。。。一个容器可以创建多个迭代器对象
 * 使用内部类。。。。实现迭代器原理
 * 加入末尾添加元素的方法
 * @author Administrator
 *
 */
public class Myiterator2 {
		//数组
		public String[] elem = {"a","b","c"};
        //数组大小
		public int size=elem.length;		
		public int size(){
			return size;
		}
		public void add(String ele){
			if(size==elem.length){//容量不够....>扩容
				elem=Arrays.copyOf(elem ,elem.length*2);
			}
			elem[size]=ele; // 数组中加入元素
			size++;			//实际大小+1
		}
		private class MyIter{
			//计数器，指针、游标
			public int cours =-1;
			//判断是否存在下一个
			boolean hashNext(){
				return cours+1<size;
			}
			//获取下一个
			public String next(){
				cours++;
				return elem[cours];
			}	
			//删除下一个
			public void remove(){
				//移动数组元素
				System.arraycopy(elem, cours+1, elem,cours , /*this.*/size-(cours+1));
				//实际大小-1
				/*this.*/size--;
				//回退
				/*this.*/cours--;
			}
		}
		public MyIter Myiter(){
			return new MyIter();
		}
		public static void main(String[] args) {		
			Myiterator2 d= new Myiterator2();			
			d.add("添加元素");
			d.add("添加元素2");
			d.add("添加元素3");			
			MyIter it = d.Myiter();
			while(it.hashNext()){	//先判断，后获取
				System.out.println(it.next());
				it.remove();
			}
//			System.out.println("$$$$$$$$$$$$$");
//			it = d.Myiter();
//			while(it.hashNext()){   //先判断，后获取
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
