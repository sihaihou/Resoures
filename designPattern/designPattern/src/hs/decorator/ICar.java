package hs.decorator;
/**
 * 抽象组件
 * @author Administrator
 */
public interface ICar {
	/**
	 * 移动
	 */
	void move();
}

/**
 * 具体构件角色(真实角色)
 * @author Administrator
 */
class Car implements ICar{
	@Override
	public void move() {
		System.out.println("陆地跑。。。。");
	}
	
}
/**
 * 装饰器角色
 * @author Administrator
 */
class SuperCar implements ICar{
	public ICar car;
	public SuperCar(ICar car) {
		this.car = car;
	}
	@Override
	public void move() {
		car.move();
	}
} 


/**
 * 具体装饰器角色
 * @author Administrator
 */
/**
 * 天上飞。。。。
 * @author Administrator
 *
 */
class flyCar extends SuperCar{
	public flyCar(ICar car) {
		super(car);
	}
	public void fly(){
		System.out.println("天上飞。。。。");
	}
	@Override
	public void move() {
		super.move();
		fly();
	}
}
/**
 * 水中游。。。。
 * @author Administrator
 */
class WaterCar extends SuperCar{
	public WaterCar(ICar car){
		super(car);
	}
	public void swim(){
		System.out.println("水中游。。。。");
	}
	@Override
	public void move() {
		super.move();
		swim();
	}
}
/**
 * 自动跑。。。。
 * @author Administrator
 */
class IDCar extends SuperCar{
	public IDCar(ICar car) {
		super(car);
	}
	public void autoMove(){
		System.out.println("自动跑。。。。");
	}
	@Override
	public void move() {
		super.move();
		autoMove();
	}
}