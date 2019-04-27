package hs.factory.abstractFactory;
/**
 * ÂÖÌ¥½Ó¿Ú
 * @author Administrator
 */
public interface Tyre {
	void revolve();
}

/**
 * ¸ß¶ËÂÖÌ¥
 * @author Administrator
 */
class LuxuryTyre implements Tyre{
	@Override
	public void revolve() {
		System.out.println("²»»áÄ¥Ëğ¡£¡£¡£¡£");
	}
}
/**
 * µÍ¶ËÂÖÌ¥
 * @author Administrator
 */
class LowTyre implements Tyre{
	@Override
	public void revolve() {
		System.out.println("Ä¥Ëğ¿ì¡£¡£¡£¡£¡£");
	}
}