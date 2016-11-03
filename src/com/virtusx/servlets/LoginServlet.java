package com.virtusx.servlets;

import com.virtusx.DB.UsersEntity;
import com.virtusx.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by x-13 on 29.10.2016.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String log = req.getParameter("login");
        String pass = req.getParameter("pass");
        UsersEntity user = UserService.getUser(log,pass);
        if(user!=null) {
            resp.sendRedirect("index.jsp");
        }
        else
            resp.sendRedirect("login.jsp?login=error");
    }
}
