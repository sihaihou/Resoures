package hs.builder;
/**
 * 建造者模式
 * @author Administrator
 */
public class App {
	public static void main(String[] args) {
		AirShipDirector director =new HisAirShipDirector(new HisAirShipBuilder());
		AirShip ship= director.directorAirShip();
		//可以调用AirShip里构建的方法(AirShip里可以构建各种指令方法)
		ship.lunch();
		System.out.println(ship.getOrbitalModule().getName());	
	}
}
