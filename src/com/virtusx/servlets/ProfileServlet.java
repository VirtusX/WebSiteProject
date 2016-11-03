package com.virtusx.servlets;

import com.virtusx.service.GameService;
import com.virtusx.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by x-13 on 31.10.2016.
 */
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String exit = req.getParameter("exit");
        String[] games = req.getParameterValues("g");
        boolean newGame = false;
        if(games!=null){
            newGame = GameService.userGamesUpdate(games);
        }
        if(exit!=null) {
            UserService.currentUser = null;
            resp.sendRedirect("index.jsp");
            return;
        }
        String pass1 = req.getParameter("pass1");
        String pass2 = req.getParameter("pass2");
        String mail = req.getParameter("mail");
        String pic = req.getParameter("pic");
        String date = req.getParameter("date");
        String loc = req.getParameter("loc");
        String about = req.getParameter("about");
        if(pass1.equals(pass2)) {
            boolean update = UserService.updateUser(pass1, mail, pic, date, loc, about);
            if(update&&!newGame){
                resp.sendRedirect("profile.jsp?submit=true");
                return;
            }
            if(update){
                resp.sendRedirect("edit_game.jsp?game=add");
            }
            else
                resp.sendRedirect("profile.jsp?submit=false");
        }
    }
}
