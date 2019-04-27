package hs.builder;
/**
 * 组装  飞船对象
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
		
		//装配成飞船对象
		AirShip ship=new AirShip();
		ship.setOrbitalModule(o);
		ship.setEscpeTower(e);
		ship.setEngine(en);
		return ship;
	}
}
