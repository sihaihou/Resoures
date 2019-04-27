package hs.builder;
/**
 * 构建 飞船的组件  接口
 * @author Administrator
 */
public interface AirShipBuilder {
	OrbitalModule builderOrbitalModule(); 
	EscpeTower builderEscpeTower();
	Engine builderEngine();
}
