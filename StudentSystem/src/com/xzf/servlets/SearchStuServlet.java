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

public class SearchStuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String sname = request.getParameter("sname");
        String gender = request.getParameter("gender");

        StudentService service = new StudentServiceImpl();
        try {
            List<Student> list = service.searchStu(sname, gender);
            request.setAttribute("list", list);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
