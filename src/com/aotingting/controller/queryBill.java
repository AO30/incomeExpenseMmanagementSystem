package com.aotingting.controller;

import com.aotingting.dao.BillDaoImpl;
import com.aotingting.dao.interf.BillDao;
import com.aotingting.entity.Bill;
import com.aotingting.util.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/queryBill")
public class queryBill extends HttpServlet {
    public static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String vendor_name = request.getParameter("vendor_name");
        BillDao billDao = new BillDaoImpl(DBUtil.getCon());
        List<Bill> bills = billDao.queryByVendorName(vendor_name);
//        for (Bill b : bills){
//            System.out.println(b.getBill_id());
//        }
        request.setAttribute("bills", bills);
        RequestDispatcher rd = request.getRequestDispatcher("billPayment.jsp");
        rd.forward(request,response);

    }
}
