package hs.dao;

import java.util.List;
import java.util.Map;

import hs.pojo.User;

public interface UserDao {
	//��
	void insertUser(User user);
	//ɾ��
	void deleteUserById(int id);
	//�޸�
	void updateUser(User user);
	//��ѯ
	List<User> selectAllUserList();
	User selectUserById(int id);
	List<User> selectUserByName(String name);

}
