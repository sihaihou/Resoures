package hs.myIterator;
/**
 * �Զ���Iterator��ʵ��
 * @author ���ĺ�
 */
public class MyIterator {
		//����
		private String[] elem = {"a","b","c"};
        //�����С
		private int size=elem.length;
		//��������ָ�롢�α�
		public int cours = -1;
		public int size(){
			return size;
		}
		//�ж��Ƿ������һ��
		public boolean hashNext(){
			return cours+1<size;
		}
		//��ȡ��һ��
		public String next(){
			cours++;
			return elem[cours];
		}
		//ɾ����һ��
		public void remove(){
			//�ƶ�����Ԫ��
			System.arraycopy(elem, cours+1, elem, cours, size-(cours+1));
			//ʵ�ʴ�С-1
			size--;
			//����
			cours--;
		}
		public static void main(String[] args) {
			MyIterator d= new MyIterator();	
			if(d.hashNext()){
				System.out.println(d.next());	
				d.remove();
			}else{
				System.out.println("û���ڴ���");
			}
			if(d.hashNext()){
				System.out.println(d.next());	
				d.remove();
			}else{
				System.out.println("û���ڴ���");
			}
			if(d.hashNext()){
				System.out.println(d.next());	
				d.remove();
			}else{
				System.out.println("û���ڴ���");
			}
			if(d.hashNext()){
				System.out.println(d.next());	
				d.remove();
			}else{
				System.out.println("û���ڴ���");
			}
			System.out.println(d.size());
		}
}
