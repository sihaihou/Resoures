package action;

import java.util.Date;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 手动验证
 * @author Administrator
 *
 */
public class RegisterAction1 extends ActionSupport{
	private String name;
	private String pwd;
	private int age;
	private Date birthday;
	public String age(){
		System.out.println("age");
		return Action.SUCCESS;
	}
	public void validateAge(){
		System.out.println("validateAge");
		if(age>100||age<0){
			this.addActionError("年龄不合法");
		}
	}
	@Override
	public void validate() {
		System.out.println("validate");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
