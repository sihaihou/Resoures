package hs.iterator;
/**
 * 自定义  迭代器接口
 * @author Administrator
 */
public interface MyIterator {
	/**
	 * 将游标指向第一个元素
	 */
	void first(); 
	/**
	 * 将游标指向下一一个元素
	 */
	void next();	
	/**
	 * 是否存在下一一个元素
	 * @return
	 */
	boolean HasNext();  
	/**
	 * 是否是第一个元素
	 * @return
	 */
	boolean isfirst();	
	/**
	 * 是否是最后一个元素
	 * @return
	 */
	boolean isLast();		
	/**
	 * 获取当前游标指向的对象
	 * @return
	 */
	Object getCurrentObj();	
}
