package com.xzf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xzf.dao.StuDao;
import com.xzf.domain.Student;
import com.xzf.util.JDBCUtil;

public class StuDaoImpl implements StuDao {

	@Override
	public List<Student> findAll() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<Student> list = new ArrayList<Student>();
		
		try {
			//1.得到连接对象
			connection = JDBCUtil.getConnection();
			String sql = "select * from s_user";
			pStatement = connection.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			
			while (rSet.next()) {
				Student student = new Student();
				
				student.setSid(rSet.getInt("sid"));
				student.setAge(rSet.getInt("age"));
				student.setGender(rSet.getString("sname"));
				student.setSname(rSet.getString("gender"));
				student.setAddress(rSet.getString("address"));
				student.setPhoneNum(rSet.getString("phoneNum"));
				
				list.add(student);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(connection, pStatement, rSet);
		}
		
		return list;
	}

}
