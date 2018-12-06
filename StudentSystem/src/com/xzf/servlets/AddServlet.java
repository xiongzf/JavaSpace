package com.xzf.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzf.domain.Student;
import com.xzf.services.StudentService;
import com.xzf.services.impl.StudentServiceImpl;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			String sname = request.getParameter("sname");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday");
			String info = request.getParameter("info");
			
			String[] hobbys = request.getParameterValues("hobby");
			String hobby = Arrays.toString(hobbys);
			hobby = hobby.substring(1, hobby.length() - 1);
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			
			Student student = new Student(sname, gender, phone, hobby, info, date);
			
			StudentService service = new StudentServiceImpl();
			
			boolean isSuccess = service.insert(student);
			if (isSuccess) {
				request.getRequestDispatcher("StudentListServlet").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
