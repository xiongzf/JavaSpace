package com.xzf.dao;

/**
 * 
 * @author user
 *	该 dao 定义了一个对用户表的访问规则
 */
public interface UserDao {
	/**
	 * 返回一个 bool 类型,成功或者失败
	 * 
	 * 正常情况下,登录的方法,一旦成功,这里就应该返回用户的个人信息
	 */
	boolean login(String username, String pwd);
	void deleteUser(int id);
}
