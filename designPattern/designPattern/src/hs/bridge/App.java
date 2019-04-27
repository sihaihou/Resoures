package hs.bridge;
/**
 * 桥接模式：可以取代多层继承的方案！
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		Brand c=new ASUS(new Laptop());
		c.sale();		
	}
}
