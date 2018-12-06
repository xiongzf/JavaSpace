package com.xzf.services.impl;

import java.util.List;

import com.xzf.dao.StudentDao;
import com.xzf.dao.impl.StudentDaoImpl;
import com.xzf.domain.PageBean;
import com.xzf.domain.Student;
import com.xzf.services.StudentService;

public class StudentServiceImpl implements StudentService {

	private static final int pagesize = StudentDao.page_size;

	@Override
	public List<Student> findAll() throws Exception {
		StudentDao dao = new StudentDaoImpl();
		return dao.findAll();
	}

	@Override
	public Boolean insert(Student student) throws Exception {
		StudentDao dao = new StudentDaoImpl();
		boolean isSuccess = dao.insert(student);
		return isSuccess;
	}

	@Override
	public Boolean delete(String sid) throws Exception {
		StudentDao dao = new StudentDaoImpl();
		boolean isSuccess = dao.delete(sid);
		return isSuccess;
	}

	@Override
	public Student findStudent(String sid) throws Exception {
		StudentDao dao = new StudentDaoImpl();
		return dao.findStudent(sid);
	}

	@Override
	public Boolean update(Student student) throws Exception {
		StudentDao dao = new StudentDaoImpl();
		boolean isSuccess = dao.update(student);
		return isSuccess;
	}

	@Override
	public List<Student> searchStu(String sname, String gender) throws Exception {
		StudentDao dao = new StudentDaoImpl();
		return dao.searchStu(sname, gender);
	}

	@Override
	public PageBean<Student> findStudentByPage(int currentPage) throws Exception {
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pagesize);
		
		StudentDao dao = new StudentDaoImpl();
		List<Student> list = dao.findByPage(currentPage);
		pageBean.setList(list);
		
		int count = dao.findCount();
		pageBean.setTotalSize(count);
		pageBean.setTotalPage(count % pagesize == 0 ? (count / pagesize) : (count / pagesize) + 1);
		
		return pageBean;
	}

}