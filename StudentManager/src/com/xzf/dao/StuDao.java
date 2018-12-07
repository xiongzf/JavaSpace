package com.xzf.dao;

import java.util.List;

import com.xzf.domain.Student;

public interface StuDao {
    /**
     * 查询出来所有的学生信息
     *
     * @return list 集合
     */
    List<Student> findAll();
}
