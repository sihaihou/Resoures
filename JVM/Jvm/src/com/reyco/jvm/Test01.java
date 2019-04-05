package com.reyco.jvm;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * 获取垃圾收集器
 * @author reyco
 * 	内存设置：
 *		-Xms:初始堆大小
 *		-Xmx:最大堆大小
 *		-Xmn：设置年轻代大小
 *		-Xss： 设置每个线程的 Java 栈大小
 *		-XX:NewSize=n:设置年轻代大小
 *		-XX:NewRatio=n:设置年轻代和年老代的比值
 *		-XX:SurvivorRatio=n:年轻代中 Eden 区与两个 Survivor 区的比值
 *		-XX:MaxPermSize=n:设置持久代大小
 *		-XX:MaxTenuringThreshold：设置垃圾最大年龄
 *	收集器设置：
 *		-XX:+UseSerialGC:设置串行收集器，年轻带收集器， 次收集器
 *		-XX:+UseParallelGC:设置并行收集器
 *		-XX:+UseParNewGC:设置年轻代为并行收集。
 *		-XX:+UseParallelOldGC:设置并行年老代收集器
 *		-XX:+UseConcMarkSweepGC:设置年老代并发收集器，
 *		-XX:+UseG1GC:设置 G1 收集器
 *	垃圾回收统计信息：
 *		-XX:+PrintGC
 *		-XX:+Printetails
 *		-XX:+PrintGCTimeStamps
 *		-Xloggc:filename
 */
public class Test01 {
	public static void main(String[] args) {
		/**
		 * -XX:+UseSerialGC
		 */
		List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
		for (GarbageCollectorMXBean garbageCollectorMXBean : garbageCollectorMXBeans) {
			System.out.println(garbageCollectorMXBean.getName());
		}
	}
}
