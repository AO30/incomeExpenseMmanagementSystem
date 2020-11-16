package com.aotingting.controller;

import com.aotingting.dao.UserDaoImpl;
import com.aotingting.dao.interf.UserDao;
import com.aotingting.entity.User;
import com.aotingting.util.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class Login extends HttpServlet {
    public static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao userDao = new UserDaoImpl(DBUtil.getCon());
        List<User> users= userDao.login(username,password);
        User user = new User();
        if(users.isEmpty()){
            String a = "用户名密码错误";
            request.setAttribute("a", a);
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request,response);
        }else {
            user.setFlag(users.get(0).getFlag());
            if ("manager".equals(user.getFlag())){
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
            }
        }
    }
}
