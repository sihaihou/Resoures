package hs.service;
/**
 * 代理角色
 * @author Administrator
 *
 */
public class UserServiceProxy implements UserService{
	private UserService userService;

	public UserServiceProxy(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void add() {
		log("add");
		userService.add();
	}
	@Override
	public void delete() {
		log("delete");
		userService.delete();
	}
	@Override
	public void update() {
		log("update");
		userService.update();
	}
	@Override
	public void search() {
		log("search");
		userService.search();
	}
	public void log(String methodName){
		System.out.println("执行"+methodName+"日志");
	}
}
 