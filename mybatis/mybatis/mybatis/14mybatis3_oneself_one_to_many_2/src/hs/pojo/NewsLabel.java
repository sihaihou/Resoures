package hs.pojo;

import java.util.Set;
/**
 * ��ѯָ����Ŀ��������������Ŀ
 * @author Administrator
 *
 */
public class NewsLabel {
	private int id;
	private String name;
	private Set<NewsLabel> children;
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
	public Set<NewsLabel> getChildren() {
		return children;
	}
	public void setChildren(Set<NewsLabel> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "NewsLabel [id=" + id + ", name=" + name + ", children=" + children + "]";
	}
}
