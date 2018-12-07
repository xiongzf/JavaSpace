package com.xzf.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    static String driverClass = null;
    static String url = null;
    static String user = null;
    static String pwd = null;

    static {
        try {
//            InputStream is = new FileInputStream("jdbc.properties");
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(is);

            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            pwd = properties.getProperty("pwd");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;

        try {
            //1、注册驱动
            // 方法1
            //    Driver driver = new Driver();
            //    DriverManager.registerDriver(driver);
            // 方法2
            //    Class.forName(driverClass);
            //2、建立连接
            conn = DriverManager.getConnection(url, user,
                    pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return conn;
    }

    public static void release(Connection cc, Statement st, ResultSet rs) {
        closeRs(rs);
        closeSt(st);
        closeCc(cc);
    }

    public static void release(Connection cc, Statement st) {
        closeSt(st);
        closeCc(cc);
    }

    public static void release(Connection cc, PreparedStatement st, ResultSet rs) {
        closeRs(rs);
        closePst(st);
        closeCc(cc);
    }

    public static void release(Connection cc, PreparedStatement st) {
        closePst(st);
        closeCc(cc);
    }

    private static void closeRs(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeSt(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closePst(PreparedStatement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeCc(Connection cc) {
        if (cc != null) {
            try {
                cc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
