package com.reyco.core.util;

import java.util.Map;

import org.apache.commons.collections.map.LRUMap;

public class CacheUtils {

	@SuppressWarnings("unchecked")
	private static Map<Object, Object> cache = new LRUMap(100000);
	
	public synchronized static void put(Object key, Object value) {
		cache.put(key, value);
	}

	public synchronized static void put(Object key, Object value, Long expired) {
		cache.put(key, value);
	}

	public synchronized static Object get(Object key) {
		return cache.get(key);
	}

	public synchronized static void remove(Object key) {
		cache.remove(key);
	}
}
