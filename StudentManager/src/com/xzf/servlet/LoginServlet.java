package com.xzf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzf.dao.StuDao;
import com.xzf.dao.UserDao;
import com.xzf.dao.impl.StuDaoImpl;
import com.xzf.dao.impl.UserDaoImpl;
import com.xzf.domain.Student;

/**
 * 这是用于处理登录的
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1.获取用户端提交的信息
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		//2.去数据库查询比对
		UserDao userDao = new UserDaoImpl();
		boolean isSuccess = userDao.login(username, pwd);
		
		if (isSuccess) {
			//1.查询所有学生的信息
			StuDao stuDao = new StuDaoImpl();
			List<Student> list = stuDao.findAll();
			//2.先把这个集合存到作用域
			request.getSession().setAttribute("list", list);
			//3.跳转新界面
			response.sendRedirect("stu_list.jsp");
		} else {
			response.getWriter().write("用户名或者密码错误!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
