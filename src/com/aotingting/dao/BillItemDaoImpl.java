package com.aotingting.dao;

import com.aotingting.dao.interf.BillItemDao;
import com.aotingting.entity.Bill;
import com.aotingting.entity.BillItem;
import com.aotingting.entity.Dept;
import com.aotingting.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BillItemDaoImpl implements BillItemDao {
    private Connection con;
    Statement st = null;
    ResultSet rs = null;
    int flag = 0;

    public BillItemDaoImpl(Connection con){
        this.con = con;
    }

    @Override
    public int addBillItem(int dept_id, int bill_id, double item_expense) {
        try {
            st = con.createStatement();
            String sql = "insert into t_bill_item(dept_id,bill_id,bill_item_expense) values('"+ dept_id +"','"+ bill_id +"','"+ item_expense +"')";
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


    @Override
    public List<BillItem> queryById(int bill_id) {
        List<BillItem> bills = new ArrayList<BillItem>();
        try {
            st = con.createStatement();
            String sql = "select b.*,bi.bill_item_expense,d.dept_name from t_bill b,t_bill_item bi,t_dept d where b.bill_id="+ bill_id +" and bi.bill_id="+ bill_id +" and bi.dept_id=d.dept_id";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            while (rs.next()){
                Bill b = new Bill();
                Dept dept = new Dept();
                BillItem billItem = new BillItem();
                b.setBill_id(rs.getInt("bill_id"));
                b.setBill_date(rs.getString("bill_date"));
                b.setBill_due_date(rs.getString("bill_due_date"));
                b.setBill_paid_flag(rs.getBoolean("bill_paid_flag"));
                b.setBill_amount(rs.getInt("bill_amount"));
                billItem.setBill_item_expense(Double.parseDouble(rs.getString("bill_item_expense")));
                dept.setDept_name(rs.getString("dept_name"));
                billItem.setDept(dept);
                billItem.setBill(b);
                bills.add(billItem);
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
}
