package com.aotingting.controller;

import com.aotingting.dao.DeptDaoImpl;
import com.aotingting.dao.IncomeDaoImpl;
import com.aotingting.dao.interf.DeptDao;
import com.aotingting.dao.interf.IncomeDao;
import com.aotingting.entity.Dept;
import com.aotingting.entity.Income;
import com.aotingting.util.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateIncome1")
public class updateIncome1 extends HttpServlet {
    public static final long serialVersionUID = 1L;

    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Income income = new Income();
//        Dept dept = new Dept();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        IncomeDao incomeDao = new IncomeDaoImpl(DBUtil.getCon());
        DeptDao deptDao = new DeptDaoImpl(DBUtil.getCon());
        String id = request.getParameter("income_id");
        System.out.println(id);
        int income_id = Integer.parseInt(id);
        List<Income> incomes = incomeDao.queryById(income_id);
        request.setAttribute("incomes", incomes);
        List<Dept> depts = deptDao.query();
        request.setAttribute("depts", depts);
        for (Income i : incomes){
            System.out.println(i.getIncome_id());
            System.out.println(i.getDept().getDept_name());
        }

//        String dept_name =  request.getParameter("dept_name");
//        String daily = request.getParameter("daily_income");
//        double daily_income = Double.parseDouble(daily);
//        income.setDaily_income(daily_income);
//        income.setIncome_id(income_id);
//        dept.setDept_name(dept_name);
//        income.setDept(dept);
//        request.setAttribute("income", income);
//        System.out.println(income.getIncome_id());
        RequestDispatcher rd = request.getRequestDispatcher("updateIncome.jsp");
        rd.forward(request,response);
    }
}
