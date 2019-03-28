package hs.decorator;
/**
 * �������
 * @author Administrator
 */
public interface ICar {
	/**
	 * �ƶ�
	 */
	void move();
}

/**
 * ���幹����ɫ(��ʵ��ɫ)
 * @author Administrator
 */
class Car implements ICar{
	@Override
	public void move() {
		System.out.println("½���ܡ�������");
	}
	
}
/**
 * װ������ɫ
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
 * ����װ������ɫ
 * @author Administrator
 */
/**
 * ���Ϸɡ�������
 * @author Administrator
 *
 */
class flyCar extends SuperCar{
	public flyCar(ICar car) {
		super(car);
	}
	public void fly(){
		System.out.println("���Ϸɡ�������");
	}
	@Override
	public void move() {
		super.move();
		fly();
	}
}
/**
 * ˮ���Ρ�������
 * @author Administrator
 */
class WaterCar extends SuperCar{
	public WaterCar(ICar car){
		super(car);
	}
	public void swim(){
		System.out.println("ˮ���Ρ�������");
	}
	@Override
	public void move() {
		super.move();
		swim();
	}
}
/**
 * �Զ��ܡ�������
 * @author Administrator
 */
class IDCar extends SuperCar{
	public IDCar(ICar car) {
		super(car);
	}
	public void autoMove(){
		System.out.println("�Զ��ܡ�������");
	}
	@Override
	public void move() {
		super.move();
		autoMove();
	}
}