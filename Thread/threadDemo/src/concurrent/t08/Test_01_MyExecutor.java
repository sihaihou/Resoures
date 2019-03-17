package concurrent.t08;

import java.util.concurrent.Executor;
/**
 * 线程池
 * 	Executor - 线程池底层处理机制。
 * 在使用线程池的时候，底层如何调用线程中的逻辑。
 */
public class Test_01_MyExecutor implements Executor {
	public static void main(String[] args) {
		new Test_01_MyExecutor().execute(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " - test executor");
			}
		});
	}

	@Override
	public void execute(Runnable command) {
		new Thread(command).start();
	}
}
