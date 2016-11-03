package com.virtusx.servlets;

import com.virtusx.service.GameService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by x-13 on 02.11.2016.
 */
public class GameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("gameName");
        String author = req.getParameter("gameAuthor");
        String pic = req.getParameter("gamePic");
        String about = req.getParameter("gameAbout");
        String mod = req.getParameter("game");
        String oldName = req.getParameter("name");
        boolean edited;
        boolean hasAdded = false;
        boolean hasEdited = false;
        switch (mod){
            case "add":
                hasAdded = GameService.addGame(name,author,pic,about);
                edited = false;
                break;
            case "edit":
                hasEdited = GameService.editGame(name,author,pic,about,oldName);
                edited = true;
                break;
            default:
                resp.sendRedirect("edit_game.jsp?game=add&submit=false");
                return;
        }
        if(hasAdded||hasEdited){
            resp.sendRedirect("profile.jsp");
        }
        else if(edited){
            resp.sendRedirect("edit_game.jsp?game=edit&submit=false");
        }
        else{
            resp.sendRedirect("edit_game.jsp?game=add&submit=false");
        }
    }
}
