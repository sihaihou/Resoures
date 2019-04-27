package hs.iterator;
/**
 * µü´úÆ÷Ä£Ê½
 * @author Administrator
 */
public class App {
	public static void main(String[] args) {
		ConcreteMyAggregate cma=new ConcreteMyAggregate();
		cma.addObject("aaa");
		cma.addObject("bbb");
		cma.addObject("ccc");
		MyIterator iterator=cma.CreateIterator();
		while(iterator.HasNext()){
			System.out.println(iterator.getCurrentObj());
			iterator.next();
		}
		System.out.println("----------------------------------");
		cma.removeObject("bbb");
		MyIterator iter=cma.CreateIterator();
		while(iter.HasNext()){
			System.out.println(iter.getCurrentObj());
			iter.next();
		}
	}
}
