package hs.pojo;

import java.io.Serializable;

public class ScoreId implements Serializable{
	private int stuId;//Ñ§ºÅ
	private int subId;//¿ÆÄ¿±àºÅ
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
}
