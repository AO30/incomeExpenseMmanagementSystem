package com.aotingting.controller;

import com.aotingting.dao.BillItemDaoImpl;
import com.aotingting.dao.interf.BillItemDao;
import com.aotingting.entity.BillItem;
import com.aotingting.util.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateBill1")
public class updateBill1 extends HttpServlet {
    public static final long serialVersionUID = 1L;

    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("bill_id");
        int bill_id = Integer.parseInt(id);
        BillItemDao billItemDao = new BillItemDaoImpl(DBUtil.getCon());
        List<BillItem> billItems= billItemDao.queryById(bill_id);
        request.setAttribute("billItems", billItems);
        RequestDispatcher rd = request.getRequestDispatcher("billPay.jsp");
        rd.forward(request, response);


    }
}
