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

@WebServlet("/updateVendor1")
public class updateVendor1 extends HttpServlet {
    public static final long serialVersionUID = 1L;

    protected void service (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("vendor_id");
        System.out.println(id);
        int vendor_id = Integer.parseInt(id);
        VendorDao vendorDao = new VendorDaoImpl(DBUtil.getCon());
        List<Vendor> vendors = vendorDao.queryVendorById(vendor_id);
        request.setAttribute("vendors", vendors);
        for (Vendor i : vendors){
            System.out.println(i.getVendor_id());
        }
        RequestDispatcher rd = request.getRequestDispatcher("updateVendor.jsp");
        rd.forward(request,response);
    }

}
