package com.xzf.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * 
 * @author user
 * 
 * 这是一个数据库连接池
 * 一开始先往池子里放10个连接
 *
 */
public class MyDataSource implements DataSource {
	List<Connection> list = new ArrayList<Connection>();
	public MyDataSource() {
		for (int i = 0; i < 10; i++) {
			Connection connection = JDBCUtil.getConnection();
			list.add(connection);
		}
	}
	
	//该连接池对外公布获取连接的方法
	@Override
	public Connection getConnection() throws SQLException {
		if (list.size() == 0) {
			for (int i = 0; i < 5; i++) {
				Connection connection = JDBCUtil.getConnection();
				list.add(connection);
			}
		}
		
		Connection connection = list.remove(0);
		return connection;
	}
	
	public void addBack(Connection connection) {
		list.add(connection);
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
