package com.xzf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xzf.dao.UserDao;
import com.xzf.util.JDBCUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean login(String username, String pwd) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		
		try {
			//1.得到连接对象
			connection = JDBCUtil.getConnection();
			String sql = "select * from t_user where username=? and password=?";
			//2.创建 ps 对象
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, username);
			pStatement.setString(2, pwd);
			
			//3.开始执行
			rSet = pStatement.executeQuery();
			
			//4.如果能够成功移到下一条数据,那么表明有这个对象
			return rSet.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(connection, pStatement, rSet);
		}
		
		return false;
	}

	@Override
	public void deleteUser(int id) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			String sql = "delete from t_user where id = ?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			
			int result = pStatement.executeUpdate();
			
			if (result == 1) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
