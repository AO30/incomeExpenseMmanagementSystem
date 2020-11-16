package com.aotingting.dao;

import com.aotingting.dao.interf.BillDao;
import com.aotingting.entity.Bill;
import com.aotingting.entity.Vendor;
import com.aotingting.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImpl implements BillDao {
    private Connection con;
    Statement st = null;
    ResultSet rs = null;
    int flag = 0;
    int key = -1;

    public BillDaoImpl(Connection con){
        this.con = con;
    }

    @Override
    public List<Bill> queryByVendorName(String vendor_name) {
        List<Bill> bills = new ArrayList<Bill>();
        try {
            st = con.createStatement();
            String sql = "select b.*,v.vendor_name from t_bill b,t_vendor v where bill_paid_flag=0 and b.vendor_id=(select vendor_id from t_vendor where vendor_name='"+ vendor_name +"') and v.vendor_id=(select vendor_id from t_vendor where vendor_name='"+ vendor_name+"')";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            while (rs.next()){
                Bill b = new Bill();
                Vendor vendor = new Vendor();
                b.setBill_id(rs.getInt("bill_id"));
                b.setBill_date(rs.getString("bill_date"));
                b.setBill_due_date(rs.getString("bill_due_date"));
                b.setBill_paid_flag(rs.getBoolean("bill_paid_flag"));
                b.setBill_amount(rs.getInt("bill_amount"));
                vendor.setVendor_id(rs.getInt("vendor_id"));
                vendor.setVendor_name(vendor_name);
                b.setVendor(vendor);
                bills.add(b);
            }
//            for (Bill d : bills){
//                System.out.println(d.getBill_id());
//            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.Close(rs, st, con);
        }
        return bills;
    }

    @Override
    public int addBill(int vendor_id, String bill_date, String bill_due_date, double bill_amount) {
        try {
            st = con.createStatement();
            String sql = "insert into t_bill(vendor_id,bill_date,bill_due_date,bill_paid_flag,bill_amount) values('"+ vendor_id +"','"+ bill_date +"','"+ bill_due_date +"','0','"+ bill_amount +"')";
            System.out.println("sql:" + sql);
            st.execute(sql);
            String sql1 = "select max(bill_id) from t_bill";
            rs = st.executeQuery(sql1);
            if(rs.next()){
                key = rs.getInt(1);
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.Close(rs, st, con);
        }
        System.out.println(key);
        return key;
    }

    @Override
    public int updateBill(int bill_id) {
        try {
            st = con.createStatement();
            String sql = "update t_bill set bill_paid_flag=1 where bill_id="+ bill_id +"";
            System.out.println("sql:" + sql);
            st.executeUpdate(sql);
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
