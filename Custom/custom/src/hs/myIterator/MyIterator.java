package hs.myIterator;
/**
 * 自定义Iterator的实现
 * @author 侯四海
 */
public class MyIterator {
		//数组
		private String[] elem = {"a","b","c"};
        //数组大小
		private int size=elem.length;
		//计数器，指针、游标
		public int cours = -1;
		public int size(){
			return size;
		}
		//判断是否存在下一个
		public boolean hashNext(){
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
			System.arraycopy(elem, cours+1, elem, cours, size-(cours+1));
			//实际大小-1
			size--;
			//回退
			cours--;
		}
		public static void main(String[] args) {
			MyIterator d= new MyIterator();	
			if(d.hashNext()){
				System.out.println(d.next());	
				d.remove();
			}else{
				System.out.println("没有内存啦");
			}
			if(d.hashNext()){
				System.out.println(d.next());	
				d.remove();
			}else{
				System.out.println("没有内存啦");
			}
			if(d.hashNext()){
				System.out.println(d.next());	
				d.remove();
			}else{
				System.out.println("没有内存啦");
			}
			if(d.hashNext()){
				System.out.println(d.next());	
				d.remove();
			}else{
				System.out.println("没有内存啦");
			}
			System.out.println(d.size());
		}
}
