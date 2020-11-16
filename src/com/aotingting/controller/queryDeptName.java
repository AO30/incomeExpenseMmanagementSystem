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

@WebServlet("/queryDeptName")
public class queryDeptName extends HttpServlet {
    public static final long serialVersionUID = 1L;

    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        DeptDao deptDao = new DeptDaoImpl(DBUtil.getCon());
        List<Dept> depts = deptDao.query();
//        for (Dept d : depts){
//            System.out.println(d.getDept_id());
//            System.out.println(d.getDept_name());
//            System.out.println(d.getDept_description());
//        }
        request.setAttribute("depts", depts);
        RequestDispatcher rd = request.getRequestDispatcher("addIncome.jsp");
        rd.forward(request,response);
    }
}
