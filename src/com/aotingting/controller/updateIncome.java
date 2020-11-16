package com.aotingting.controller;

import com.aotingting.dao.IncomeDaoImpl;
import com.aotingting.dao.interf.IncomeDao;
import com.aotingting.util.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateIncome")
public class updateIncome extends HttpServlet {

    public static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("income_id");
        int income_id = Integer.parseInt(id);
        String income = request.getParameter("daily_income");
        double dept_income = Double.parseDouble(income);
        System.out.println(id + "  " + dept_income);
        IncomeDao incomeDao = new IncomeDaoImpl(DBUtil.getCon());
        incomeDao.update_income(income_id, dept_income);
        RequestDispatcher rd = request.getRequestDispatcher("/queryIncome");
        rd.forward(request, response);
    }

}
