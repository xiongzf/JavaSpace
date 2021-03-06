package com.xzf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xzf.dao.StudentDao;
import com.xzf.domain.Student;
import com.xzf.util.JDBCUtil2;
import com.xzf.util.TextUtils;

/**
 * @author user
 * 这是 studentDao 的实现
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> findAll() throws Exception {
        QueryRunner qRunner = new QueryRunner(JDBCUtil2.getDataSource());
        String sql = "select * from stu";
        List<Student> list = qRunner.query(sql, new BeanListHandler<Student>(Student.class));
        return list;
    }

    @Override
    public Boolean insert(Student student) throws Exception {
        QueryRunner qRunner = new QueryRunner(JDBCUtil2.getDataSource());
        String sql = "insert into stu values(null, ?, ?, ?, ?, ?, ?)";
        int code = qRunner.update(sql, student.getSname(), student.getGender(), student.getPhone(), student.getBirthday(), student.getHobby(), student.getInfo());
        return code == 1;
    }

    @Override
    public Boolean delete(String sid) throws Exception {
        QueryRunner qRunner = new QueryRunner(JDBCUtil2.getDataSource());
        String sql = "delete from stu where sid = ?";
        int code = qRunner.update(sql, sid);
        return code == 1;
    }

    @Override
    public Student findStudent(String sid) throws Exception {
        QueryRunner qRunner = new QueryRunner(JDBCUtil2.getDataSource());
        String sql = "select * from stu where sid = ?";
        Student student = qRunner.query(sql, new BeanHandler<Student>(Student.class), sid);
        return student;
    }

    @Override
    public Boolean update(Student student) throws Exception {
        QueryRunner qRunner = new QueryRunner(JDBCUtil2.getDataSource());
        String sql = "update stu set sname=?, gender=?, phone=?, birthday=?, hobby=?, info=? where sid=?";
        int code = qRunner.update(sql, student.getSname(), student.getGender(), student.getPhone(), student.getBirthday(), student.getHobby(), student.getInfo(), student.getSid());
        return code == 1;
    }

    @Override
    public List<Student> searchStu(String sname, String gender) throws Exception {
        QueryRunner qRunner = new QueryRunner(JDBCUtil2.getDataSource());
        String sql = "select * from stu where 1=1";
        List<String> strings = new ArrayList<String>();

        if (!TextUtils.isEmpty(sname)) {
            sql += " and sname like ?";
            strings.add("%" + sname + "%");
        }

        if (!TextUtils.isEmpty(gender)) {
            sql += " and gender like ?";
            strings.add(gender);
        }

        List<Student> list = qRunner.query(sql, new BeanListHandler<Student>(Student.class), strings.toArray());

        return list;
    }

    @Override
    public List<Student> findByPage(int currentPage) throws Exception {
        QueryRunner qRunner = new QueryRunner(JDBCUtil2.getDataSource());
        //第一个❓代表一页返回多少条记录, 第二个❓跳过前面多少条记录
        String sql = "select * from stu limit ? offset ?";
        List<Student> list = qRunner.query(sql, new BeanListHandler<Student>(Student.class), page_size, page_size * (currentPage - 1));
        return list;
    }

    @Override
    public int findCount() throws Exception {
        QueryRunner qRunner = new QueryRunner(JDBCUtil2.getDataSource());
        //第一个❓代表一页返回多少条记录, 第二个❓跳过前面多少条记录
        String sql = "select count(*) from stu";
        Long result = (Long) qRunner.query(sql, new ScalarHandler());
        return result.intValue();
    }

}
