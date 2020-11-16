package com.aotingting.dao;

import com.aotingting.dao.interf.DeptDao;
import com.aotingting.entity.Dept;
import com.aotingting.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    private Connection con;
    Statement st = null;
    ResultSet rs = null;
    int flag = 0;

    public DeptDaoImpl(Connection con){
        this.con = con;
    }

    @Override
    public int addDept(String dept_name, String description) {
        try {
            st = con.createStatement();
            String sql = "insert into t_dept(dept_name,dept_description) values('"+ dept_name +"','"+ description +"')";
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
    public int updateDept(int dept_id, String dept_name, String dept_description) {
        try {
            st = con.createStatement();
            String sql = "update t_dept set dept_name='"+ dept_name +"',dept_description='"+ dept_description +"' where dept_id= "+ dept_id +"";
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

    @Override
    public List<Dept> query() {
        List<Dept> depts = new ArrayList<Dept>();
        try {
            st = con.createStatement();
            String sql = "select * from t_dept";
            rs = st.executeQuery(sql);
            while (rs.next()){
                Dept d = new Dept();
                d.setDept_id(rs.getInt("dept_id"));
                d.setDept_name(rs.getString("dept_name"));
                d.setDept_description(rs.getString("dept_description"));
                depts.add(d);
            }
//            for (Dept d : depts){
//                System.out.println(d.getDept_id());
//                System.out.println(d.getDept_name());
//                System.out.println(d.getDept_description());
//            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.Close(rs, st, con);
        }
        return depts;
    }

    @Override
    public List<Dept> queryById(int dept_id) {
        List<Dept> depts = new ArrayList<Dept>();
        try {
            st = con.createStatement();
            String sql = "select * from t_dept where dept_id="+ dept_id +"";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            while (rs.next()){
                Dept d = new Dept();
                d.setDept_id(rs.getInt("dept_id"));
                d.setDept_name(rs.getString("dept_name"));
                d.setDept_description(rs.getString("dept_description"));
                depts.add(d);
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.Close(rs, st, con);
        }
        return depts;
    }
}
