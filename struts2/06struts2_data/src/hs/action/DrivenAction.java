package hs.action;

import com.opensymphony.xwork2.ModelDriven;

import hs.pojo.User;
/**
 * ����ģ��:ʵ��ModelDriven�ӿ�
 * @author Administrator
 *
 */
public class DrivenAction implements ModelDriven<User>{
	private User user = new User();	
	public String execute(){
		System.out.println(user);
		return "register";			
	}
	@Override
	public User getModel() {
		return user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
