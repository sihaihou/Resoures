package hs.pojo;
/**
 * 多对一：
 * 	 一
 * @author Administrator
 */
public class Country {
	private Integer cid;
	private String cname;
		
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + "]";
	}
}
