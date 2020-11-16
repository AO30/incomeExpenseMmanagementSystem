package com.aotingting.dao;

import com.aotingting.dao.interf.UserDao;
import com.aotingting.entity.User;
import com.aotingting.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private Connection con;

    public UserDaoImpl(Connection con){
        this.con = con;
    }

    @Override
    public List<User> login(String username, String password) {
        List<User> users = new ArrayList<>();
        boolean flag = false;
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            String sql = "select * from t_user where username ='" + username + "' and password ='" + password + "'";
            rs = st.executeQuery(sql);
            while (rs.next()){
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFlag(rs.getString("flag"));
                users.add(user);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.Close(rs, st, con);
        }
        return users;
    }
}
