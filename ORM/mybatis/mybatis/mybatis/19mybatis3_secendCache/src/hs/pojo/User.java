package hs.pojo;

import java.io.Serializable;
/**	
 *	开启内置的二级缓存：
 *		1，在映射文件中添加<cache/>标签，
 *		2，对实体类进行序列化。
 *
 *	二级缓存的使用原则：
 *		1，多个namespace不要操作同一张表
 *		2，不要在关联关系表上进行增删改操作。
 *		3，查询多余修改使用二级缓存
 *		
 * @author Administrator
 *
 */
public class User implements Serializable{
	private int id;
	private String name;
	private int age;
	public User() {
	}
	public User( String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public User(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name:" + name + ", age:" + age + "]";
	}	
}
