package com.reyco.annotation.test;

import com.reyco.annotation.core.AppcationXml;
import com.reyco.annotation.entity.Parson;

public class Test<T> {

	public static void main(String[] args) throws Exception {
		Test test = new Test();
		test.testIOC();
	}
	public void testIOC() {
		AppcationXml mapperFilter = new AppcationXml("reyco.xml");
		Object obj = mapperFilter.getbean("parson");
		if (obj instanceof Parson) {
			Parson p = (Parson) obj;
			System.out.println(p.getName());
		}
	}
}
