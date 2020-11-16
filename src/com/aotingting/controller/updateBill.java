package com.aotingting.controller;

import com.aotingting.dao.BillDaoImpl;
import com.aotingting.dao.CheckDaoImpl;
import com.aotingting.dao.PaymentDaoImpl;
import com.aotingting.dao.interf.BillDao;
import com.aotingting.dao.interf.CheckDao;
import com.aotingting.dao.interf.PaymentDao;
import com.aotingting.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/updateBill")
public class updateBill extends HttpServlet {
    public static final long serialVersionUID = 1L;
//    String check_id;
    String check_number;
//    int[] cid1 = new int[10];
    int[] cnumber = new int[10];

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("bill_id");
        int bill_id = Integer.parseInt(id);
        int flag = Integer.parseInt(request.getParameter("box"));
        if(flag == 1){
//            check_id = request.getParameter("check_id");
//            System.out.println(check_id);
            check_number = request.getParameter("check_number");
        }
//        String[] cid = check_id.split(",");
        String[] number = check_number.split(",");
        for(int i = 0;i<number.length;i++){
//            cid1[i] = Integer.parseInt(cid[i]);
            cnumber[i] = Integer.parseInt(number[i]);
            CheckDao checkDao = new CheckDaoImpl(DBUtil.getCon());
            PaymentDao paymentDao = new PaymentDaoImpl(DBUtil.getCon());
            int k = checkDao.addCheck(cnumber[i]);
            paymentDao.addPayment(k,bill_id);
        }
        BillDao billDao = new BillDaoImpl(DBUtil.getCon());
        billDao.updateBill(bill_id);

    }
}
