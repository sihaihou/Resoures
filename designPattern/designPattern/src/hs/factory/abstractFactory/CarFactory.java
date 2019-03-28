package hs.factory.abstractFactory;
/**
 * 汽车工厂
 * @author Administrator
 */
public interface CarFactory {
	Engine createEngine();  //创建引擎
	Seat createSeat();		//座椅
	Tyre createTyre();		//轮胎
}
