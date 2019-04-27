package hs.builder;
/**
 * ��װ  �ɴ�����
 * @author Administrator
 */
public class HisAirShipDirector implements AirShipDirector{
	private  AirShipBuilder builder;
	public HisAirShipDirector(AirShipBuilder builder) {
		this.builder=builder;
	}
	@Override
	public AirShip directorAirShip() {
		OrbitalModule o=builder.builderOrbitalModule();
		EscpeTower e=builder.builderEscpeTower();
		Engine en=builder.builderEngine();
		
		//װ��ɷɴ�����
		AirShip ship=new AirShip();
		ship.setOrbitalModule(o);
		ship.setEscpeTower(e);
		ship.setEngine(en);
		return ship;
	}
}
