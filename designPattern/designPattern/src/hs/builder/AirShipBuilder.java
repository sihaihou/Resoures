package hs.builder;
/**
 * ���� �ɴ������  �ӿ�
 * @author Administrator
 */
public interface AirShipBuilder {
	OrbitalModule builderOrbitalModule(); 
	EscpeTower builderEscpeTower();
	Engine builderEngine();
}
