package com.aotingting.controller;

import com.aotingting.dao.DeptDaoImpl;
import com.aotingting.dao.interf.DeptDao;
import com.aotingting.entity.Dept;
import com.aotingting.util.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateDepartment")
public class updateDepartment extends HttpServlet {
    public static final long serialVersionUID = 1L;


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("dept_id");
        int dept_id = Integer.parseInt(id);
        System.out.println(dept_id);
        DeptDao deptDao = new DeptDaoImpl(DBUtil.getCon());
        List<Dept> depts = deptDao.queryById(dept_id);
        request.setAttribute("dept", depts);
//        for (Dept d : depts){
//            System.out.println(d.getDept_id());
//            System.out.println(d.getDept_name());
//            System.out.println(d.getDept_description());
//        }
        RequestDispatcher rd = request.getRequestDispatcher("updateDepartment.jsp");
        rd.forward(request, response);
    }

}
