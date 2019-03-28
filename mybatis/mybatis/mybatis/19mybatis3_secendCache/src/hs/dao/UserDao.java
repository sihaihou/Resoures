package hs.dao;

import hs.pojo.User;
/**	
 *	开启内置的二级缓存：
 *		1，在映射文件中添加<cache/>标签，
 *		2，对实体类进行序列化。
 * @author Administrator
 *
 */
public interface UserDao {
	
	public User selectUserById(int id );
	public User selectUserById2(int id );
	public void insertUser(User user);

}

