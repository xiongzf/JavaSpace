package com.xzf.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xzf.domain.Account;

public class TestDBUtils {

    @Test
    public void testInsert() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        QueryRunner queryRunner = new QueryRunner(dataSource);
//		queryRunner.update("insert into account values (null, ?, ?)", "hhh", 100);
//		queryRunner.update("delete from account where id = ?", 17);
//		queryRunner.update("update account set money = ? where id = ?", 10, 8);

        Account account = queryRunner.query("select * from account where id = ?", new ResultSetHandler<Account>() {

            @Override
            public Account handle(ResultSet arg0) throws SQLException {
                Account account = new Account();
                while (arg0.next()) {
                    account.setName(arg0.getString("name"));
                    account.setMoney(arg0.getDouble("money"));
                    account.setId(arg0.getInt("id"));
                }
                return account;
            }

        }, 8);

        System.out.println(account.toString());
    }

    @Test
    public void testQuery() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        QueryRunner queryRunner = new QueryRunner(dataSource);
//		Account account = queryRunner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class) , 8);
        List<Account> list = queryRunner.query("select * from account", new BeanListHandler<Account>(Account.class));

        for (Account account : list) {
            System.out.println(account.toString());
        }

    }
}
