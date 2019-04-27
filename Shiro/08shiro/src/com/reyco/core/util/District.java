package com.reyco.core.util;

public class District {
	private Long id;
	private Long cid;
	private String districtName;

	public District(Long id, Long cid, String districtName) {
		this.id = id;
		this.cid = cid;
		this.districtName = districtName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
}