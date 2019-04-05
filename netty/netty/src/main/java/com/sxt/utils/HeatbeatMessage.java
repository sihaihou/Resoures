package com.sxt.utils;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

public class HeatbeatMessage implements Serializable {

	private static final long serialVersionUID = 2827219147304706826L;
	private String ip;
	private Map<String, Object> cpuMsgMap;
	private Map<String, Object> memMsgMap;
	private Map<String, Object> fileSysMsgMap;
	@Override
	public String toString() {
		return "HeatbeatMessage [\nip=" + ip 
				+ ", \ncpuMsgMap=" + cpuMsgMap 
				+ ", \nmemMsgMap=" + memMsgMap
				+ ", \nfileSysMsgMap=" + fileSysMsgMap + "]";
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Map<String, Object> getCpuMsgMap() {
		return cpuMsgMap;
	}
	public void setCpuMsgMap(Map<String, Object> cpuMsgMap) {
		this.cpuMsgMap = cpuMsgMap;
	}
	public Map<String, Object> getMemMsgMap() {
		return memMsgMap;
	}
	public void setMemMsgMap(Map<String, Object> memMsgMap) {
		this.memMsgMap = memMsgMap;
	}
	public Map<String, Object> getFileSysMsgMap() {
		return fileSysMsgMap;
	}
	public void setFileSysMsgMap(Map<String, Object> fileSysMsgMap) {
		this.fileSysMsgMap = fileSysMsgMap;
	}
	
}
