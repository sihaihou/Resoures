package hs.factory.abstractFactory;
/**
 * 引擎接口
 * @author Administrator
 */
public interface Engine {
	void run();
	void start();
}

/**
 * 高端引擎
 * @author Administrator
 */
class LuxuryEngine implements Engine{
	@Override
	public void run() {
		System.out.println("速度快。。。。。。");
	}
	@Override
	public void start() {
		System.out.println("启动快，。。。。。。");
	}
}

/**
 * 低端引擎
 * @author Administrator
 */
class LowyEngine implements Engine{
	@Override
	public void run() {
		System.out.println("速度慢。。。。。。");
	}
	@Override
	public void start() {
		System.out.println("启动慢，。。。。。。");
	}
}