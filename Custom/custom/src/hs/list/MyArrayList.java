package hs.list;
/**
 * 自定义ArrayList容器
 * @author 侯四海
 */
public class MyArrayList {
	//容器对象
	private Object[] elementData;
	//容器大小 
	private int size;
	/**
	 * 返回容器大小(size)
	 * @return int
	 */
	public int size(){
		return size;
	}
	/**
	 * 初始化容器大小
	 */	
	public MyArrayList() {
		this(10);
	}
	/**
	 * 创建一个新容器
	 * @param size
	 */
	public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
        	try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        elementData = new Object[initialCapacity];		       
	}
	/**
	 * 添加(add)对象
	 * @param obj
	 */	 
	 public void add(Object obj){
		 ensoureCopacity();	 	//数组扩容和数据拷贝
		 elementData[size++]= obj;
	 } 
	 /**
	  * 根据索引添加对象
	  * @param index
	  * @param obj
	  */
	 public void add(int index,Object obj){
		 rangeCheck(index);	 //索引检测
		 ensoureCopacity();	 //数组扩容和数据拷贝
		 System.arraycopy(elementData, index, elementData, index + 1,size - index);
 		 elementData[index] = obj;
 		 size++;
	 }
	 /**
	  * 容器是否为null
	  * @return boolean
	  */
	 public boolean isEmpty(){
		 return size ==0;
	 }
	/**
	 * 	根据索引设置该对象 
	 * @param index
	 * @param obj
	 * @return Object
	 */
	 public Object set(int index,Object obj){
		 rangeCheck(index);		//索引检测
		 Object oldValue = elementData[index];
		 elementData[index] =obj;
		 return oldValue;
	 }
	 /**
	  * 根据索引获取该对象
	  * @param index
	  * @return Object
	  */
	 public Object get(int index){
		 rangeCheck(index);		//索引检测
		 return elementData[index];
	 }
	 /**
	  * 根据索引移除该对象
	  * @param index
	  */
	 public void Remove(int index){
		 rangeCheck(index);
		 int numindex=size-index-1;
		 if(index>=0){
			 System.arraycopy(elementData, index+1, elementData, index, numindex);			 
		 }
		 elementData[--size] = null;
	 }
	 /**
	  * 根据对象移除该对象
	  * @param obj
	  */
	 public void remove(Object obj) {
	      for(int i=0;i<size;i++){
	    	  if(get(i).equals(obj)){
	    		  remove(i);
	    	  }
	      }
	 }
	 /**
	  * 索引值范围检测
	  * @param index
	  */
	 private void rangeCheck(int index){
		 if(index>=size){
			 try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
	 }
	 /**
	  * 数组扩容和数据拷贝
	  */
	 private void ensoureCopacity(){		 
		 if(size==elementData.length){
			 Object[] newArray = new Object[size*2];
			 System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			 //自定义拷贝(copy)
			/* for(int i=0;i<elementData.length;i++){
				 newArray[i] = elementData[i];
			 }*/
			 elementData=newArray;
		 } 
	 }
	 /**
	  * 测试
	  * @param args
	  */
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(3);
		list.add("55");
		list.add("55");
		list.add("5315");
		list.add("555");
		list.add(0, "897");
//		list.set(2,"33");
//		list.remove("55");
//	     list.Remove(2);
		for(int i=0;i<list.size;i++){
			System.out.println(list.get(i));
		}	
	}
}
