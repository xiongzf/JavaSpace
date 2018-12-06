package com.xzf.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

public class TestPool {
	
	@Test
	public void testPool() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		MyDataSource dataSource = new MyDataSource();
		try {
			connection = dataSource.getConnection();
			String sql = "insert into account values (null, 'xilali', 1000)";
			pStatement = connection.prepareStatement(sql);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			dataSource.addBack(connection);
		}
		
	}
}
