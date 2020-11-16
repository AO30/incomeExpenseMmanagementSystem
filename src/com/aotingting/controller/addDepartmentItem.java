package com.aotingting.controller;

import com.aotingting.dao.DeptDaoImpl;
import com.aotingting.dao.VendorDaoImpl;
import com.aotingting.dao.interf.DeptDao;
import com.aotingting.dao.interf.VendorDao;
import com.aotingting.entity.Dept;
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

@WebServlet("/addDepartmentItem")
public class addDepartmentItem extends HttpServlet {
    public static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String bill_date = request.getParameter("bill_date");
//        System.out.println(bill_date);
        String bill_due_date = request.getParameter("bill_due_date");
//        System.out.println(bill_due_date);
        String id = request.getParameter("vendor_id");
//        System.out.println(id);
        int vendor_id = Integer.parseInt(id);
        DeptDao deptDao = new DeptDaoImpl(DBUtil.getCon());
        VendorDao vendorDao = new VendorDaoImpl(DBUtil.getCon());
        List<Vendor> vendors = vendorDao.queryVendorById(vendor_id);
        List<Dept> depts = deptDao.query();
//        for (Vendor v : vendors){
//            System.out.println(v.getVendor_name());
//        }
//        for (Dept d : depts){
//            System.out.println(d.getDept_id());
//        }
        request.setAttribute("bill_date", bill_date);
        request.setAttribute("bill_due_date", bill_due_date);
        request.setAttribute("vendor_id", vendor_id);
        request.setAttribute("vendors", vendors);
        request.setAttribute("depts", depts);
        RequestDispatcher rd = request.getRequestDispatcher("addDepartmentItem.jsp");
        rd.forward(request, response);
    }

}
