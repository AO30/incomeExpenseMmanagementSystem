package com.aotingting.controller;

import com.aotingting.dao.IncomeDaoImpl;
import com.aotingting.dao.interf.IncomeDao;
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

@WebServlet("/queryIncomeByTime")
public class queryIncomeByTime  extends HttpServlet {
    public static final long serialVersionUID = 1L;

    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        IncomeDao incomeDao = new IncomeDaoImpl(DBUtil.getCon());
        String date = request.getParameter("date");
        System.out.println(date);
        List<Income> incomes = incomeDao.queryByTime(date);
//        for (Income i : incomes){
//            System.out.println(i.getBusiness_date());
//            System.out.println(i.getDept().getDept_name());
//        }
        request.setAttribute("incomes", incomes);
        RequestDispatcher rd = request.getRequestDispatcher("incomeMain.jsp");
        rd.forward(request,response);
    }
}
