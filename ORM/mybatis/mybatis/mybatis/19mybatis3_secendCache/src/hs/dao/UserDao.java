package hs.dao;

import hs.pojo.User;
/**	
 *	�������õĶ������棺
 *		1����ӳ���ļ������<cache/>��ǩ��
 *		2����ʵ����������л���
 * @author Administrator
 *
 */
public interface UserDao {
	
	public User selectUserById(int id );
	public User selectUserById2(int id );
	public void insertUser(User user);

}

