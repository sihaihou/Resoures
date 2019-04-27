package com.reyco.core.util;

public class HoroscopeUtils {

	public static String getHoroscope(String birthday) {
		int day = Integer.valueOf(birthday.substring(4, 8));
		if (day >= 121 && day<= 219) {
			return "ˮƿ��";
		}
		if (day >= 220 && day<= 320) {
			return "˫����";
		}
		if (day >= 321 && day<= 420) {
			return "������";
		}
		if (day >= 421 && day<= 521) {
			return "��ţ��";
		}
		if (day >= 522 && day<= 621) {
			return "˫����";
		}
		if (day >= 622 && day<= 722) {
			return "��з��";
		}
		if (day >= 723 && day<= 823) {
			return "ʨ����";
		}
		if (day >= 824 && day<= 923) {
			return "��Ů��";
		}
		if (day >= 924 && day<= 1023) {
			return "�����";
		}
		if (day >= 1024 && day<= 1122) {
			return "��Ы��";
		}
		if (day >= 1123 && day<= 1221) {
			return "������";
		}
		return "ħ����";
	}
}
