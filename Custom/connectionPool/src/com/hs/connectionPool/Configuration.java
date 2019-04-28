package com.hs.connectionPool;

/*
 * ≈‰÷√–≈œ¢
 */
public class Configuration {
	private String 	mysqlDriver;
	private String	mysqlURL;
	private String	mysqlUser;
	private String	mysqlPwd;
	private Integer poolMaxSize;
	private Integer	poolMinSize;
	public Configuration() {
		
	}
	public Configuration(String mysqlDriver, String mysqlURL, String mysqlUser, String mysqlPwd, Integer poolMaxSize,
			Integer poolMinSize) {
		super();
		this.mysqlDriver = mysqlDriver;
		this.mysqlURL = mysqlURL;
		this.mysqlUser = mysqlUser;
		this.mysqlPwd = mysqlPwd;
		this.poolMaxSize = poolMaxSize;
		this.poolMinSize = poolMinSize;
	}
	public String getMysqlDriver() {
		return mysqlDriver;
	}
	public void setMysqlDriver(String mysqlDriver) {
		this.mysqlDriver = mysqlDriver;
	}
	public String getMysqlURL() {
		return mysqlURL;
	}
	public void setMysqlURL(String mysqlURL) {
		this.mysqlURL = mysqlURL;
	}
	public String getMysqlUser() {
		return mysqlUser;
	}
	public void setMysqlUser(String mysqlUser) {
		this.mysqlUser = mysqlUser;
	}
	public String getMysqlPwd() {
		return mysqlPwd;
	}
	public void setMysqlPwd(String mysqlPwd) {
		this.mysqlPwd = mysqlPwd;
	}
	public Integer getPoolMaxSize() {
		return poolMaxSize;
	}
	public void setPoolMaxSize(Integer poolMaxSize) {
		this.poolMaxSize = poolMaxSize;
	}
	public Integer getPoolMinSize() {
		return poolMinSize;
	}
	public void setPoolMinSize(Integer poolMinSize) {
		this.poolMinSize = poolMinSize;
	}
	@Override
	public String toString() {
		return "Configuration [mysqlDriver=" + mysqlDriver + ", mysqlURL=" + mysqlURL + ", mysqlUser=" + mysqlUser
				+ ", mysqlPwd=" + mysqlPwd + ", poolMaxSize=" + poolMaxSize + ", poolMinSize=" + poolMinSize + "]";
	}
}
