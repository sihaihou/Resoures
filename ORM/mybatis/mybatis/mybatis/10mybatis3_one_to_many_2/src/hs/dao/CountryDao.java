package hs.dao;

import hs.pojo.Country;

public interface CountryDao {
	
	public Country selectCountryById(int cid);
	
}
