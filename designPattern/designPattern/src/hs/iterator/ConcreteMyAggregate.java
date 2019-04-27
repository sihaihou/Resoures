package hs.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义聚合类
 * @author Administrator
 */
public class ConcreteMyAggregate {
	private List<Object> list =new ArrayList();
	/**
	 * 添加对象
	 * @param obj
	 */
	public void addObject(Object obj){
		list.add(obj);
	}
	/**
	 * 移除对象
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
	 * 获取迭代器方法
	 * @return
	 */
	public MyIterator CreateIterator(){
		return new ConcreteIterator();
	}
	
	
	
	/**
	 * 使用内部类定义迭代器，可以直接使用外部类的属性
	 * @author Administrator
	 */
	private class ConcreteIterator implements MyIterator{
		 /**
		  * 定义游标---用于记录遍历List容器时的位置
		  */
		private int cursor; 
		/**
		 * 当前游标置零
		 */
		@Override
		public void first() {
			cursor=0;
		}
		/**
		 * 获取当期游标对象
		 */
		@Override
		public Object getCurrentObj() {
			return list.get(cursor);
		}	
		/**
		 * 将游标指向下一个元素
		 */
		@Override
		public void next() {
			if(cursor<list.size()){
				cursor++;
			}
		}
		/**
		 * 是否存在下一个元素
		 */
		@Override
		public boolean HasNext() {
			if(cursor<list.size()){
				return true;
			}
			return false;
		}
		/**
		 * 判断当前对象是否第一个元素
		 */
		@Override
		public boolean isfirst() {
			return cursor==0?true:false;
		}
		/**
		 * 判断当前对象是否最后一个元素
		 */
		@Override
		public boolean isLast() {
			return cursor==(list.size()-1)?true:false;
		}
	} 
}
