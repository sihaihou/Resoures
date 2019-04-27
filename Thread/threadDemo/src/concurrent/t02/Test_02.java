/**
 * 
 */
package concurrent.t02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *  wait   notify
 * @author reyco
 *
 */
public class Test_02 {
	public static void main(String[] args) {
		final Test_02_Container t = new Test_02_Container();
		final Object lock = new Object();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				synchronized (lock) {
					if(t.size() != 5){
						try {
							lock.wait(); // 线程进入等待队列。
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("size = 5");
					lock.notifyAll(); // 唤醒其他等待线程
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					for(int i = 0; i < 10; i++){
						System.out.println("add Object to Container " + i);
						t.add(new Object());
						if(t.size() == 5){
							lock.notifyAll();
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
	}
}

class Test_02_Container{
	List<Object> container = new ArrayList<>();
	
	public void add(Object o){
		this.container.add(o);
	}
	
	public int size(){
		return this.container.size();
	}
}