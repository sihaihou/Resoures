package action;

import java.util.Date;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
/**
 * �ֶ���֤
 * @author Administrator
 *
 */
public class RegisterAction extends ActionSupport{
	private String name;
	private String pwd;
	private int age;
	private Date birthday;
	@Override
	public String execute() throws Exception {
		System.out.println("execute");
		return Action.SUCCESS;
	}	
	@Override
	public void validate() {
		if(age>100 || age<0 ){
			this.addActionError("���䲻�Ϸ���");
		}
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
