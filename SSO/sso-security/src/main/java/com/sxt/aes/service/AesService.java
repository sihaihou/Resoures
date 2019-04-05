package com.sxt.aes.service;

import com.sxt.aes.utils.AesResponse;

public interface AesService {

	public AesResponse testAes(String key, String securityMessage, String name, String password);
	
}
