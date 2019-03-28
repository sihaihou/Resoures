package hs.service;
/**
 * ¿Í»§
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		UserServiceProxy userServiceProxy = new UserServiceProxy(userService);
		userServiceProxy.delete();
	}
}
