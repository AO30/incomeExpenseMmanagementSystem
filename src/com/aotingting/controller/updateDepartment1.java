package com.aotingting.controller;

import com.aotingting.dao.DeptDaoImpl;
import com.aotingting.dao.interf.DeptDao;
import com.aotingting.util.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateDepartment1")
public class updateDepartment1 extends HttpServlet {
    public static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("dept_id");
        int dept_id = Integer.parseInt(id);
        String dept_name = request.getParameter("dept_name");
        String dept_description = request.getParameter("dept_description");
//        System.out.println(id + "  " + dept_income);
        DeptDao deptDao = new DeptDaoImpl(DBUtil.getCon());
        deptDao.updateDept(dept_id,dept_name, dept_description);
        RequestDispatcher rd = request.getRequestDispatcher("/queryDept");
        rd.forward(request, response);
    }
}
