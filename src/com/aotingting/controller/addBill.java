package com.aotingting.controller;

import com.aotingting.dao.BillDaoImpl;
import com.aotingting.dao.BillItemDaoImpl;
import com.aotingting.dao.interf.BillDao;
import com.aotingting.dao.interf.BillItemDao;
import com.aotingting.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addBill")
public class addBill extends HttpServlet {
    public static final long serialVersionUID = 1L;
    double amount = 0;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String bill_date = request.getParameter("bill_date");
        String bill_due_date = request.getParameter("bill_due_date");
        String id = request.getParameter("vendor_id");
        int vendor_id = Integer.parseInt(id);
        //得到选中复选框的值
        String [] boxes = request.getParameterValues("bill_item_expense");
        if(boxes != null){
            for(int i = 0; i<boxes.length;i++){
                String text = request.getParameter(boxes[i]);
                double bill_item_expense = Double.parseDouble(text);
                amount = amount + bill_item_expense;
            }
        }
        BillDao billDao = new BillDaoImpl(DBUtil.getCon());
        int k = billDao.addBill(vendor_id, bill_date, bill_due_date,amount);
        if(boxes != null){
            for(int i = 0; i<boxes.length;i++){

                BillItemDao billItemDao = new BillItemDaoImpl(DBUtil.getCon());
                //得到选中复选框的值  是对应文本框name属性的值
//                System.out.println(boxes[i]);  //   1   2
                int dept_id = Integer.parseInt(boxes[i]);
                // 得到选中复选框对应文本框的值
                String text = request.getParameter(boxes[i]);
                double bill_item_expense = Double.parseDouble(text);
//                System.out.println(boxes[i] + "  " + text);
                billItemDao.addBillItem(dept_id,k,bill_item_expense);
            }
        }
    }
}
