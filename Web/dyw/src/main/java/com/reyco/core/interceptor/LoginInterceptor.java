package com.reyco.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.reyco.core.pojo.User;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = null;
		try {
			user = (User)request.getSession().getAttribute("user");
			String to = request.getRequestURI();
			logger.info("request to " + to + "  | 登录前处理:" + user);
			return true;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		User user = null;
		try {
			user = (User)request.getSession().getAttribute("user");
			String url = request.getRequestURI();
			//用户
			String name = user.getName();
			//setUserInfo(name,user,60*30);
			//在线用户id
			//Long user_id = (long) Integer.parseInt(name.substring(7));
			//添加用户到OnlineUser列表
			//setOnLineUser("onlineUser",user_id);
			//统计在线人数
			//Integer count = printOnLineUser("onlineUser");
			logger.info("request to " + url + "  | 登录后处理:" + user.toString());
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	/**
	 * 清除工作
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		User user = null;
		try {
			user = (User)request.getSession().getAttribute("user");
			String key = user.getName();
			//打印redisString类型的key、value
			//printString(key);
		}catch (Exception e) {
		}
	}
	/**
	 * 打印redisString类型的key、value
	 * @param key
	 */
	/*public static void printString(String key) {
		if(RedisUtils.exists(key)) {
			String value = RedisUtils.get(key);
			System.out.println("key="+key+",value="+value);
		}
	}*/
	/**
	 * 设置登录用户到redis缓存,并指定key,超时时间
	 * @param userKey    key
	 * @param user       value信息
	 * @param timeout    timeout
	 */
	/*private static void setUserInfo(String userKey,User user,Integer timeout) {
		//获取登录用户，作redis登录缓存key
		String loginKey = user.getName();
		//判断key是否存在,不存在则设置到redis缓存中,
		if(!RedisUtils.exists(loginKey)) {
			//设置key、value、timeout
			RedisUtils.set(loginKey, user.toString(),timeout);
		}
		
	}*/
	/**
	 * 根据用户信息,设置到redis的hash中,并指定key 
	 * @param userKey  key
	 * @param user     value信息
	 */
	/*private static void setHashUserInfo(String userKey,User user) {
		//创建一个map,用于存放用户信息
		Map<String,String> map = new HashMap<String,String>();
		map.put("ip", user.getIp());
		map.put("city", user.getCity());
		map.put("name", user.getName());
 		RedisUtils.setHash(userKey, map);
	}*/
	/**
	 * 根据用户key,打印用户信息
	 * @param userKey
	 */
/*	private static void printHashUserInfo(String userKey) {
		// 获取用户hash
		Map<String,String> hash = RedisUtils.getHash(userKey);
		//遍历map，并打印
		for(Map.Entry<String, String> item : hash.entrySet()) {
			System.out.println(item.getKey() + " : " + item.getValue());
	    }
	}*/
	 /**
     * 添加用户到OnlineUser列表
     * @param user
     */
 /*  public static void setOnLineUser(String onLineUserKey,Long userId) {
  	  	Jedis jedis = RedisUtils.getJedis();
        Date currentTime = new Date();
        String timeStr = new SimpleDateFormat("yyyy-MM-dd").format(currentTime);
        onLineUserKey = timeStr+"-onLineUser";
        jedis.setbit(onLineUserKey, userId, true);
   }*/
   /**
    * 统计在线人数
    * @param onLineUserKey
    */
  /* public static Integer printOnLineUser(String onLineUserKey) {
	   Jedis jedis = RedisUtils.getJedis();
       Date currentTime = new Date();
       BitSet all = new BitSet();
       String timeStr = new SimpleDateFormat("yyyy-MM-dd").format(currentTime);
       onLineUserKey = timeStr+"-onLineUser";
       byte[] loginByte = jedis.get(onLineUserKey.getBytes());
       //有可能当天没有一个用户登录
       if(loginByte!=null){
           BitSet user = BitSet.valueOf(loginByte); 
           //取其并集
           all.or(user);
       }
       //统计人数
       return all.cardinality();
   }*/
}
