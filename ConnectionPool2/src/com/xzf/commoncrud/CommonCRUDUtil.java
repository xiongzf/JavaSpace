package com.xzf.commoncrud;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.xzf.domain.Account;
import com.xzf.util.JDBCUtil2;

public class CommonCRUDUtil {

    class A implements ResultSetHandler<Account> {

        @Override
        public Account handle(ResultSet resultSet) {
            try {
                if (resultSet.next()) {
                    Account account = new Account();
                    account.setId(resultSet.getInt("id"));
                    account.setName(resultSet.getString("name"));
                    account.setMoney(resultSet.getDouble("money"));
                    return account;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

    @Test
    public void testQuery() {
        Account account = query("select * from account where id = ?", new ResultSetHandler<Account>() {
            @Override
            public Account handle(ResultSet resultSet) {

                try {
                    if (resultSet.next()) {
                        Account account = new Account();
                        account.setId(resultSet.getInt("id"));
                        account.setName(resultSet.getString("name"));
                        account.setMoney(resultSet.getDouble("money"));
                        return account;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }, 3);
        System.out.println(account.toString());

        Account account2 = query("select * from account where id = ?", new A(), 12);
        System.out.println(account2.toString());
    }

    public <T> T query(String sql, ResultSetHandler<T> handler, Object... args) {
        Connection connection = null;
        PreparedStatement pStatement = null;

        try {
            connection = JDBCUtil2.getConnection();
            pStatement = connection.prepareStatement(sql);

            //元数据
            //获取有几个占位符
            ParameterMetaData data = pStatement.getParameterMetaData();
            int count = data.getParameterCount();
            for (int i = 0; i < count; i++) {
                pStatement.setObject(i + 1, args[i]);
            }

            ResultSet rSet = pStatement.executeQuery();
            T t = (T) handler.handle(rSet);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil2.release(connection, pStatement);
        }

        return null;
    }

    //通用的增删改查方法

    /**
     * 以参数个数为主
     *
     * @param sql
     * @param args
     */
    public void update(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement pStatement = null;

        try {
            connection = JDBCUtil2.getConnection();
            pStatement = connection.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                pStatement.setObject(i + 1, args[i]);
            }

            pStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil2.release(connection, pStatement);
        }
    }

    /**
     * 以问号为主
     *
     * @param sql
     * @param args
     */
    public void update2(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement pStatement = null;

        try {
            connection = JDBCUtil2.getConnection();
            pStatement = connection.prepareStatement(sql);

            //元数据
            //获取有几个占位符
            ParameterMetaData data = pStatement.getParameterMetaData();
            int count = data.getParameterCount();
            for (int i = 0; i < count; i++) {
                pStatement.setObject(i + 1, args[i]);
            }

            pStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil2.release(connection, pStatement);
        }
    }

}
