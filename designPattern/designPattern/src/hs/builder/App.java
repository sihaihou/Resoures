package hs.builder;
/**
 * ������ģʽ
 * @author Administrator
 */
public class App {
	public static void main(String[] args) {
		AirShipDirector director =new HisAirShipDirector(new HisAirShipBuilder());
		AirShip ship= director.directorAirShip();
		//���Ե���AirShip�ﹹ���ķ���(AirShip����Թ�������ָ���)
		ship.lunch();
		System.out.println(ship.getOrbitalModule().getName());	
	}
}
