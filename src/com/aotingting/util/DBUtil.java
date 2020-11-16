package com.aotingting.util;

import java.sql.*;

public class DBUtil {
    public static Connection getCon(){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai";
        String user = "root";
        String password = "Ao991010";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }

    public static void Close(ResultSet rs, Statement st, Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
