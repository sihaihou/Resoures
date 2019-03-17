package com.reyco.core.util;

public class HoroscopeUtils {

	public static String getHoroscope(String birthday) {
		int day = Integer.valueOf(birthday.substring(4, 8));
		if (day >= 121 && day<= 219) {
			return "Ë®Æ¿×ù";
		}
		if (day >= 220 && day<= 320) {
			return "Ë«Óã×ù";
		}
		if (day >= 321 && day<= 420) {
			return "°×Ñò×ù";
		}
		if (day >= 421 && day<= 521) {
			return "½ğÅ£×ù";
		}
		if (day >= 522 && day<= 621) {
			return "Ë«×Ó×ù";
		}
		if (day >= 622 && day<= 722) {
			return "¾ŞĞ·×ù";
		}
		if (day >= 723 && day<= 823) {
			return "Ê¨×Ó×ù";
		}
		if (day >= 824 && day<= 923) {
			return "´¦Å®×ù";
		}
		if (day >= 924 && day<= 1023) {
			return "Ìì³Ó×ù";
		}
		if (day >= 1024 && day<= 1122) {
			return "ÌìĞ«×ù";
		}
		if (day >= 1123 && day<= 1221) {
			return "ÉäÊÖ×ù";
		}
		return "Ä§ôÉ×ù";
	}
}
