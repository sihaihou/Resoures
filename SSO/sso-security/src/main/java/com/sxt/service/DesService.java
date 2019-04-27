package com.sxt.service;

import com.sxt.des.utils.DesResponse;

public interface DesService {

	public DesResponse testDes(String key, String securityMessage, String name, String password);
	
}
