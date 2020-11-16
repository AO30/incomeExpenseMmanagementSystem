package com.aotingting.controller;

import com.aotingting.dao.VendorDaoImpl;
import com.aotingting.dao.interf.VendorDao;
import com.aotingting.entity.Vendor;
import com.aotingting.util.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/queryVendor1")
public class queryVendor1 extends HttpServlet {
    public static final long serialVersionUID = 1L;

    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        VendorDao vendorDao = new VendorDaoImpl(DBUtil.getCon());
        List<Vendor> vendors = vendorDao.queryVendor();
//        for (Vendor v : vendors){
//            System.out.println(v.getVendor_id());
//        }
        request.setAttribute("vendors", vendors);
        RequestDispatcher rd = request.getRequestDispatcher("addBill.jsp");
        rd.forward(request, response);
    }
}
