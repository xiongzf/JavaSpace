package com.xzf.util;

import java.sql.*;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil2 {
	static ComboPooledDataSource dataSource = null;
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
    public static Connection getConnection() throws Exception {
        return dataSource.getConnection();
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
