package concurrent.t01;

public class Test_16 {
	Object o1 = new Object();
	Object o2 = new Object();
	
	public void a() {
		synchronized(o1) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			b();
			System.out.println("a...");
		}
	} 
	public void b() {
		synchronized(o2) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			a();
			System.out.println("b...");
		}
		
	} 
	public static void main(String[] args) {
		Test_16 t = new Test_16();
		new Thread(t::a).start();
		new Thread(t::b).start();
	}
}
