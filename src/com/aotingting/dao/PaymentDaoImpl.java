package com.aotingting.dao;

import com.aotingting.dao.interf.PaymentDao;
import com.aotingting.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PaymentDaoImpl implements PaymentDao {
    private Connection con;
    Statement st = null;
    ResultSet rs = null;
    int flag = 0;

    public PaymentDaoImpl(Connection con){
        this.con = con;
    }

    @Override
    public int addPayment(int check_id, int bill_id) {
        try {
            st = con.createStatement();
            String sql = "insert into t_payment(bill_id,check_id) values("+ bill_id +","+ check_id +")";
            System.out.println("sql:" + sql);
            st.execute(sql);
            flag = 1;
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.Close(rs, st, con);
        }
        return flag;
    }
}
