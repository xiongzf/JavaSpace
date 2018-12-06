package com.xzf.dao;

import java.util.List;

import com.xzf.domain.Student;

public interface StudentDao {
	int page_size = 10;
	/**
	 * 查找所有学生
	 * @return
	 * @throws Exception
	 */
	List<Student> findAll() throws Exception;

	/**
	 * 分页查找学生
	 * @param currentPage
	 * @return
	 * @throws Exception
	 */
	List<Student> findByPage(int currentPage) throws Exception;
	
	/**
	 * 查找总个数
	 * @return
	 * @throws Exception
	 */
	int findCount() throws Exception;
	
	/**
	 * 模糊查询
	 * @param sname
	 * @param gender
	 * @return
	 * @throws Exception
	 */
	List<Student> searchStu(String sname, String gender) throws Exception;
	
	/**
	 * 查找学生
	 * @param sid
	 * @return
	 * @throws Exception
	 */
	Student findStudent(String sid) throws Exception;
	
	/**
	 * 添加学生
	 * @param student
	 * @return
	 * @throws Exception
	 */
	Boolean insert(Student student) throws Exception;
	
	/**
	 * 删除学生
	 * @param sid
	 * @return
	 * @throws Exception
	 */
	Boolean delete(String sid) throws Exception;
	
	/**
	 * 更新学生信息
	 * @param student
	 * @return
	 * @throws Exception
	 */
	Boolean update(Student student) throws Exception;
	
}
