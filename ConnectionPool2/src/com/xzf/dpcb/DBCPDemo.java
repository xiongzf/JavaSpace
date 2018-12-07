package com.xzf.dpcb;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import com.xzf.util.JDBCUtil;

public class DBCPDemo {

    @Test
    public void test1() {
        Connection connection = null;
        PreparedStatement pStatement = null;

        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/Demo?useSSL=false");
            dataSource.setUsername("root");
            dataSource.setPassword("wq11sa22");

            connection = dataSource.getConnection();
            String sql = "insert into account values (null, 'admin', 1000)";
            pStatement = connection.prepareStatement(sql);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(connection, pStatement);
        }
    }

    @Test
    public void test2() {
        Connection connection = null;
        PreparedStatement pStatement = null;

        try {
            Properties properties = new Properties();
            InputStream iStream = new FileInputStream("src//dbcpconfig.properties");
            properties.load(iStream);

            DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);

            connection = dataSource.getConnection();
            String sql = "insert into account values (null, 'admin2', 1000)";
            pStatement = connection.prepareStatement(sql);
            pStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(connection, pStatement);
        }
    }
}
