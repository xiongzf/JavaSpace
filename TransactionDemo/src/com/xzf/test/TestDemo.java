package com.xzf.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.xzf.util.JDBCUtil;

public class TestDemo {
    @Test
    public void testTransaction() {
//		test1();
        test2();
    }

    private void test2() {
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet rSet = null;

        try {
            connection = JDBCUtil.getConnection();
            //连接, 事物默认就是自动提交的,关闭自动提交
            connection.setAutoCommit(false);

            String sql = "update account set money = money - ? where id = ?";
            pStatement = connection.prepareStatement(sql);

            pStatement.setInt(1, 100);
            pStatement.setInt(2, 1);
            pStatement.executeUpdate();

//  			 int a = 10 / 0;

            pStatement.setInt(1, -100);
            pStatement.setInt(2, 2);
            pStatement.executeUpdate();

            //成功:提交事务
            connection.commit();

        } catch (SQLException e) {
            //报错:回滚事务
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtil.release(connection, pStatement, rSet);
        }
    }

    private void test1() {
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet rSet = null;

        try {
            connection = JDBCUtil.getConnection();
            String sql = "select * from account";
            pStatement = connection.prepareStatement(sql);
            rSet = pStatement.executeQuery();

            while (rSet.next()) {
                System.out.println(rSet.getString("name") + "==" + rSet.getInt("money"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(connection, pStatement, rSet);
        }
    }
}
