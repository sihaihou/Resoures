package hs.decorator;
/**
 * װ��ģʽ
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		Car car=new Car();
		car.move();
		System.out.println("=======����¹��ܣ��ɡ�������");
		flyCar fly=new flyCar(car);
		fly.move();
		
		System.out.println("=======����¹��ܣ��ɡ����������Ρ�������");
		WaterCar water=new WaterCar(fly);
		water.move();
	}
}
