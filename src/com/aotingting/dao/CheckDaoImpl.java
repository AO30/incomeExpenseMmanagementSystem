package com.aotingting.dao;

import com.aotingting.dao.interf.CheckDao;
import com.aotingting.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CheckDaoImpl implements CheckDao {
    private Connection con;
    Statement st = null;
    ResultSet rs = null;
    int flag = 0;
    int key = -1;

    public CheckDaoImpl(Connection con) {
        this.con = con;
    }

    @Override
    public int addCheck(int check_number) {
        try {
            st = con.createStatement();
            String sql = "insert into t_check(check_number) values('"+ check_number +"')";
            System.out.println("sql:" + sql);
            st.execute(sql);
            String sql1 = "select max(check_id) from t_check";
            rs = st.executeQuery(sql1);
            if(rs.next()){
                key = rs.getInt(1);
            }
            flag = 1;
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.Close(rs, st, con);
        }
        return key;
    }
}
