package hs.dao;

import hs.pojo.User;
/**	
 *	һ������Sqlsession
 * @author Administrator
 *
 */
public interface UserDao {
	
	public User selectUserById(int id );
	public User selectUserById2(int id );
	public void insertUser(User user);

}

