package concurrent.t02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/**
 * volatile
 */
public class Test_01 {
	public static void main(String[] args) {
		final Test_01_Container t = new Test_01_Container();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++){
					System.out.println("add Object to Container " + i);
					t.add(new Object());
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					if(t.size() == 5){
						System.out.println("size = 5");
						break;
					}
				}
			}
		}).start();
	}
}

class Test_01_Container{
	volatile List<Object> container = new ArrayList<>();
	
	public void add(Object o){
		this.container.add(o);
	}	
	public int size(){
		return this.container.size();
	}
}