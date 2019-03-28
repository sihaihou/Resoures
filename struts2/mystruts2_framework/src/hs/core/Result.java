package hs.core;

public class Result {
	private String name="success";
	private String type="dispatcher";
	private String location;
	public Result() {
	}	
	public Result(String location) {
		super();
		this.location = location;
	}	
	public Result(String type, String location) {
		super();
		this.type = type;
		this.location = location;
	}
	public Result(String name, String type, String location) {
		super();
		this.name = name;
		this.type = type;
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
