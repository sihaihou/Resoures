package hs.pojo;

import java.util.Set;
/**
 * 查询指定栏目及其所有父栏目
 * @author Administrator
 */
public class NewsLabel {
	private int id;
	private String name;
	private NewsLabel parent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public NewsLabel getParent() {
		return parent;
	}
	public void setParent(NewsLabel parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "NewsLabel [id=" + id + ", name=" + name + ", parent=" + parent + "]";
	}
}
