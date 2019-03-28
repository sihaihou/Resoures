package hs.decorator;
/**
 * 装饰模式
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		Car car=new Car();
		car.move();
		System.out.println("=======添加新功能：飞。。。。");
		flyCar fly=new flyCar(car);
		fly.move();
		
		System.out.println("=======添加新功能：飞、。。。。游、、、、");
		WaterCar water=new WaterCar(fly);
		water.move();
	}
}
