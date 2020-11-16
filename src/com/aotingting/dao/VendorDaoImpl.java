package com.aotingting.dao;

import com.aotingting.dao.interf.VendorDao;
import com.aotingting.entity.Vendor;
import com.aotingting.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class VendorDaoImpl implements VendorDao {
    private Connection con;
    Statement st = null;
    ResultSet rs = null;
    int flag = 0;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Calendar calendar = Calendar.getInstance();

    public VendorDaoImpl(Connection con){
        this.con = con;
    }

    @Override
    public List<Vendor> queryVendor() {
        List<Vendor> vendors = new ArrayList<Vendor>();
        try {
            st = con.createStatement();
            String sql = "select * from t_vendor";
            rs = st.executeQuery(sql);
            while (rs.next()){
                Vendor v = new Vendor();
                v.setVendor_id(rs.getInt("vendor_id"));
                v.setVendor_name(rs.getString("vendor_name"));
                v.setVendor_address(rs.getString("vendor_address"));
                v.setVendor_phone(rs.getString("vendor_phone"));
                v.setVendor_fax(rs.getString("vendor_fax"));
                v.setVendor_contact_person(rs.getString("vendor_contact_person"));
                vendors.add(v);
            }
//            for (Vendor v : vendors){
//                System.out.println(d.getVendor_id());
//            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.Close(rs, st, con);
        }
        return vendors;
    }

    @Override
    public List<Vendor> queryVendorById(int vendor_id) {
        List<Vendor> vendors = new ArrayList<Vendor>();
        try {
            st = con.createStatement();
            String sql = "select * from t_vendor where vendor_id="+ vendor_id +"";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            while (rs.next()){
                Vendor v = new Vendor();
                v.setVendor_id(rs.getInt("vendor_id"));
                v.setVendor_name(rs.getString("vendor_name"));
                v.setVendor_address(rs.getString("vendor_address"));
                v.setVendor_phone(rs.getString("vendor_phone"));
                v.setVendor_fax(rs.getString("vendor_fax"));
                v.setVendor_contact_person(rs.getString("vendor_contact_person"));
                vendors.add(v);
            }
//            for (Vendor v : vendors){
//                System.out.println(d.getVendor_id());
//            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.Close(rs, st, con);
        }
        return vendors;
    }


    @Override
    public int addVendor(String vendor_name, String vendor_address, String vendor_phone, String vendor_fax, String vendor_contact_person) {
        try {
            st = con.createStatement();
            String sql = "insert into t_vendor(vendor_name,vendor_address,vendor_phone,vendor_fax,vendor_contact_person) values('"+ vendor_name +"','"+ vendor_address+"','"+ vendor_phone +"','"+ vendor_fax +"','"+ vendor_contact_person +"')";
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
    public int updateVendor(int vendor_id, String vendor_name, String vendor_address, String vendor_phone, String vendor_fax, String vendor_contact_person) {
        try{
            st = con.createStatement();
            String sql = "update t_vendor set vendor_name='"+ vendor_name +"',vendor_address='"+ vendor_address +"',vendor_phone='"+ vendor_phone +"', vendor_fax='"+ vendor_fax +"',vendor_contact_person='"+ vendor_contact_person +"'where vendor_id="+ vendor_id +"";
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
