package hs.list;
/**
 * �Զ���ArrayList����
 * @author ���ĺ�
 */
public class MyArrayList {
	//��������
	private Object[] elementData;
	//������С 
	private int size;
	/**
	 * ����������С(size)
	 * @return int
	 */
	public int size(){
		return size;
	}
	/**
	 * ��ʼ��������С
	 */	
	public MyArrayList() {
		this(10);
	}
	/**
	 * ����һ��������
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
	 * ���(add)����
	 * @param obj
	 */	 
	 public void add(Object obj){
		 ensoureCopacity();	 	//�������ݺ����ݿ���
		 elementData[size++]= obj;
	 } 
	 /**
	  * ����������Ӷ���
	  * @param index
	  * @param obj
	  */
	 public void add(int index,Object obj){
		 rangeCheck(index);	 //�������
		 ensoureCopacity();	 //�������ݺ����ݿ���
		 System.arraycopy(elementData, index, elementData, index + 1,size - index);
 		 elementData[index] = obj;
 		 size++;
	 }
	 /**
	  * �����Ƿ�Ϊnull
	  * @return boolean
	  */
	 public boolean isEmpty(){
		 return size ==0;
	 }
	/**
	 * 	�����������øö��� 
	 * @param index
	 * @param obj
	 * @return Object
	 */
	 public Object set(int index,Object obj){
		 rangeCheck(index);		//�������
		 Object oldValue = elementData[index];
		 elementData[index] =obj;
		 return oldValue;
	 }
	 /**
	  * ����������ȡ�ö���
	  * @param index
	  * @return Object
	  */
	 public Object get(int index){
		 rangeCheck(index);		//�������
		 return elementData[index];
	 }
	 /**
	  * ���������Ƴ��ö���
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
	  * ���ݶ����Ƴ��ö���
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
	  * ����ֵ��Χ���
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
	  * �������ݺ����ݿ���
	  */
	 private void ensoureCopacity(){		 
		 if(size==elementData.length){
			 Object[] newArray = new Object[size*2];
			 System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			 //�Զ��忽��(copy)
			/* for(int i=0;i<elementData.length;i++){
				 newArray[i] = elementData[i];
			 }*/
			 elementData=newArray;
		 } 
	 }
	 /**
	  * ����
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
