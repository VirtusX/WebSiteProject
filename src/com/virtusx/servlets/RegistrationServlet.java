package com.virtusx.servlets;

import com.virtusx.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by x-13 on 30.10.2016.
 */
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String log = req.getParameter("login");
        String pass = req.getParameter("pass");
        String mail = req.getParameter("email");
        boolean newUser = UserService.signUpUser(log,mail,pass);
        if(newUser){
            resp.sendRedirect("index.jsp");
        }
        else
            resp.sendRedirect("registration.jsp?signUp=failed");
    }
}
