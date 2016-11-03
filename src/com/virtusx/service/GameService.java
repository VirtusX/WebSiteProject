package com.virtusx.service;

import com.virtusx.DB.GamesEntity;
import com.virtusx.DB.HibernateUtil;
import com.virtusx.DB.UserGamesEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameService {

    public static List<GamesEntity> getGames(){
        List<GamesEntity> userGames = null;
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            int id = UserService.currentUser.getUserId();
            userGames = session.createQuery("from GamesEntity where gameId IN (select gameId from UserGamesEntity  where userId ="+id+")",GamesEntity.class).getResultList();

            tx.commit();
        }
        catch (Exception ex){
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }
        return userGames;
    }


    public static List<String> getGamesName(){
        return getGames().stream().map(GamesEntity::getGameName).collect(Collectors.toCollection(ArrayList::new));
    }

    public static List<String> getGamesList(){
        List<GamesEntity> gamesAll = null;
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            gamesAll = session.createQuery("from GamesEntity",GamesEntity.class).getResultList();
            tx.commit();
        }
        catch (Exception ex){
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }
        List<GamesEntity> games = gamesAll.stream().filter(ge -> !getGames().contains(ge)).collect(Collectors.toList());
        List<String> gamesName = games.stream().map(GamesEntity::getGameName).collect(Collectors.toList());

        Collections.sort(gamesName);
        return gamesName;
    }

    public static boolean userGamesUpdate(String[] games){
        Transaction tx = null;
        boolean newGame = false;
        for (String game : games) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                tx = session.beginTransaction();
                if (!game.equals("new game")) {
                    GamesEntity gameId = session.createQuery("from GamesEntity where gameName='" + game + "'", GamesEntity.class).uniqueResult();
                    UserGamesEntity last = (UserGamesEntity) session.createQuery("from UserGamesEntity order by gUId DESC").setMaxResults(1).uniqueResult();
                    UserGamesEntity uGames = new UserGamesEntity();
                    uGames.setgUId(last!=null?last.getgUId()+1:1);
                    uGames.setGameId(gameId.getGameId());
                    uGames.setUserId(UserService.currentUser.getUserId());
                    session.save(uGames);
                } else {
                    newGame = true;
                }
                tx.commit();
            } catch (Exception ex) {
                if (tx != null){
                    ex.printStackTrace();
                    tx.rollback();
                }
            }
        }
        return newGame;
    }

    public static boolean addGame(String name,String author,String pic, String about){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            GamesEntity game = new GamesEntity();
            game.setGameName(name);
            game.setGameAuthors(author);
            game.setGamePic(pic);
            game.setGameAbout(about);
            session.save(game);
            tx.commit();

            tx = session.beginTransaction();
            GamesEntity gameId = session.createQuery("from GamesEntity where gameName='" + name + "'", GamesEntity.class).uniqueResult();
            UserGamesEntity last = (UserGamesEntity) session.createQuery("from UserGamesEntity order by gUId DESC").setMaxResults(1).uniqueResult();
            UserGamesEntity uGames = new UserGamesEntity();
            uGames.setgUId(last!=null?last.getgUId()+1:1);
            uGames.setGameId(gameId.getGameId());
            uGames.setUserId(UserService.currentUser.getUserId());
            session.save(uGames);
            tx.commit();
        }
        catch (Exception ex){
            if(tx!=null){
                ex.printStackTrace();
                tx.rollback();
                return false;
            }
        }
        return true;
    }

    public static GamesEntity getGame(String name){
        GamesEntity game = null;
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            game = session.createQuery("from GamesEntity  where gameName='"+name+"'",GamesEntity.class).uniqueResult();
            tx.commit();
        }
        catch (Exception ex){
            if(tx!=null){
                ex.printStackTrace();
                tx.rollback();
            }
        }
        return game;
    }

    public static boolean editGame(String name,String author,String pic, String about,String oldName){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            GamesEntity game = session.createQuery("from GamesEntity where gameName ='"+oldName+"'",GamesEntity.class).uniqueResult();
            if(name!=null&&!name.equals(oldName))
                game.setGameName(name);
            if(author!=null&&author.length()>1)
                game.setGameAuthors(author);
            if(pic!=null&&pic.length()>1)
                game.setGamePic(pic);
            if(about!=null&&about.length()>1)
                game.setGameAbout(about);
            session.update(game);
            tx.commit();
        }
        catch (Exception ex) {
            if(tx!=null){
                ex.printStackTrace();
                tx.rollback();
                return false;
            }
        }
        return true;
    }
}
