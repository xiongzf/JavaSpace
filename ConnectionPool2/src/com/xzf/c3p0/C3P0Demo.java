package com.xzf.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.junit.Test;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xzf.util.JDBCUtil;

public class C3P0Demo {
	@Test
	public void test1() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		try {
			dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/Demo?useSSL=false");
			dataSource.setUser("root");
			dataSource.setPassword("wq11sa22");
			
			connection = dataSource.getConnection();
			String sql = "insert into account values (null, 'admin3', 1000)";
			pStatement = connection.prepareStatement(sql);
			pStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(connection, pStatement);
		}
	}
	
	@Test
	public void test2() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "insert into account values (null, 'admin3', 1000)";
			pStatement = connection.prepareStatement(sql);
			pStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(connection, pStatement);
		}
	}
}
