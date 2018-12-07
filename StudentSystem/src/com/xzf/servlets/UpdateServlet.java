package com.xzf.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzf.domain.Student;
import com.xzf.services.StudentService;
import com.xzf.services.impl.StudentServiceImpl;


public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("sid");

        StudentService service = new StudentServiceImpl();
        try {
            Student student = service.findStudent(sid);
            request.setAttribute("stu", student);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
