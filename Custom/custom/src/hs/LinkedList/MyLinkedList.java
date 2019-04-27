package hs.LinkedList;

import java.util.NoSuchElementException;
/**
 * �Զ���LinkedList����
 * @author ���ĺ�
 *
 */
public class MyLinkedList {
	private int size ;
	private Node first;
	private Node last;
	/**
	 * ����size��С
	 * @return
	 */
	public int size(){
		return size;
	}
	/**
	 * ��Ӷ���
	 * @param obj
	 */
	public void add(Object obj){
		Node n =new Node();
		if(first==null){				
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);				
			first = n;
			last = n;
		}else{
			//ֱ����last�ڵ�������µĽڵ�
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);	
			last.setNext(n);
			last= n;
		}
		size++;
	}
		
	public void add(int index,Object obj){
		Node temp =node(index);
		Node newnode=new Node();
		newnode.obj=obj;
		if(temp!=null){				
			Node up=temp.previous;
			up.next=newnode;
			newnode.previous=up;
			
			newnode.next=temp;
			temp.previous=newnode;
			size++;
		}
	}
	public Object get(int index){
		run(index);
		Node temp =node(index);	
		if(temp!=null ){
			return temp.obj;
		}			
		return null;
	}
	public void remove(int index){	
		Node temp =node(index);		
	
		if(temp!=null ){				
			Node up=temp.previous;
			Node down =temp.next;
			up.next=down;
			down.previous=up;
		}
		size--;
	}
	public   Node node(int index){
		Node temp =null;
		if(first!=null ){	
			if(index<size>>1){
				temp =first;
				for(int i =0;i<index;i++){
					temp = temp.next;
				}
			}else{
				temp = last;
				for(int i=size-1;i>index;i--){
					temp=temp.previous;
				}
			}				
		}
		return temp;
	}        
	private void run(int index){			
		 if(index<0||index>size){
			 try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
	 }
	public static void main(String[] args) {
		MyLinkedList list=new MyLinkedList();	
		list.add("AAA");
		list.add("BBB");
		list.add(1, "CCC");
		list.add("DDD");	
//		list.remove(1);
		System.out.println(list.get(3));		
	}
}




//������ʾһ���ڵ�
class Node{
	Node previous; //��һ��
	Object obj;		//�Լ�
	Node next;		//��һ��
	public Node() {
		// TODO Auto-generated constructor stub
	}
	public Node(Node previous, Node next, Object obj) {
		super();
		this.previous = previous;
		this.next = next;
		this.obj = obj;
	}
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}			
}