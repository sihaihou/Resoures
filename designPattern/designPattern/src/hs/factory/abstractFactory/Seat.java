package hs.factory.abstractFactory;
/**
 * 座椅接口
 * @author Administrator
 */
public interface Seat {
	void massage();
}

/**
 * 高端座椅
 * @author Administrator
 */
class LuxurySeat implements Seat{
	@Override
	public void massage() {
		System.out.println("高端座椅可以按摩。。。。。");
	}
}

/**
 * 低端座椅
 * @author Administrator
 */
class LowySeat implements Seat{
	@Override
	public void massage() {
		System.out.println("低端座椅不能按摩。。。。。");
	}
}