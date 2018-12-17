package com.xzf.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzf.domain.Student;
import com.xzf.services.StudentService;
import com.xzf.services.impl.StudentServiceImpl;

public class StudentListService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * 负责查询所有学生信息,然后呈现到界面上
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1.查询出来所有的数据
			StudentService service = new StudentServiceImpl();
			List<Student> list = service.findAll();
			
			//2.先把页面存储到作用域
			request.setAttribute("list", list);
			
			//3.跳转页面
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
