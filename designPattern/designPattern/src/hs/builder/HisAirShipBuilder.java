package hs.builder;
/**
 * 构建 飞船的组件 对象
 * @author Administrator
 */
public class HisAirShipBuilder implements AirShipBuilder {
	@Override
	public OrbitalModule builderOrbitalModule() {
		System.out.println("构建神州牌轨道舱。。。。");
		return new OrbitalModule("神州牌轨道舱");
	}
	@Override
	public EscpeTower builderEscpeTower() {
		System.out.println("构建神州牌逃逸塔。。。。");
		return new EscpeTower("神州牌逃逸塔");
	}
	@Override
	public Engine builderEngine() {
		System.out.println("构建神州牌引擎。。。。");
		return new Engine("神州牌引擎");
	}
}
