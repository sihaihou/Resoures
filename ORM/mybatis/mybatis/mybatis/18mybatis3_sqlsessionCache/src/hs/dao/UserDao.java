package hs.dao;

import hs.pojo.User;
/**	
 *	“ªº∂ª∫¥ÊSqlsession
 * @author Administrator
 *
 */
public interface UserDao {
	
	public User selectUserById(int id );
	public User selectUserById2(int id );
	public void insertUser(User user);

}

