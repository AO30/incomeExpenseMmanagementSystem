package com.aotingting.controller;

import com.aotingting.dao.VendorDaoImpl;
import com.aotingting.dao.interf.VendorDao;
import com.aotingting.util.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addVendor")
public class addVendor extends HttpServlet {
    public static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String vendor_name = request.getParameter("vendor_name");
        String vendor_address = request.getParameter("vendor_address");
        String vendor_phone = request.getParameter("vendor_phone");
        String vendor_fax = request.getParameter("vendor_fax");
        String vendor_contact_person = request.getParameter("vendor_contact_person");
        System.out.println(vendor_name);
        VendorDao vendorDao = new VendorDaoImpl(DBUtil.getCon());
        vendorDao.addVendor(vendor_name, vendor_address,vendor_phone, vendor_fax,vendor_contact_person);
        RequestDispatcher rd = request.getRequestDispatcher("/queryVendor");
        rd.forward(request, response);
    }
}
