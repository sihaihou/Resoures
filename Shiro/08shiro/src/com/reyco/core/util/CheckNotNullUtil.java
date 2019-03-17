package com.reyco.core.util;
/**
 *   验证是否为null
 *   验证是否为空�?
 *   
 * @author Administrator
 *
 */

public class CheckNotNullUtil {
	/**
	 *    验证非空:
	 * @param obj  目标对象
	 * @return true:表示不为空并且不为空串，false:表示为空或空串�??
	 */
	public static boolean checkNotNull(Object... obj) {
		for (Object object : obj) {
			if(null != object && !"".equals(object)) {
				return true;
			}
		}
		return false;
	}
	
}
