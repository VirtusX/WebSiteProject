package com.virtusx.service;

import com.virtusx.DB.HibernateUtil;
import com.virtusx.DB.UsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by x-13 on 30.10.2016.
 */
public class UserService {

    public static  UsersEntity currentUser = null;

    public static UsersEntity getUser(String login, String password){

        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            int mail = login.length()-login.replace("@","").length();
            if(!login.contains("@")||mail>1)
                currentUser = (UsersEntity) session.createQuery("from UsersEntity where userName='"+login+"' and userPassword='"+password+"'").uniqueResult();
            else if(mail==1){
                currentUser = (UsersEntity) session.createQuery("from UsersEntity where userEmail='"+login+"'and userPassword='"+password+"'").uniqueResult();
            }
            tx.commit();
        }
        catch (Exception ex){
            if(tx!=null){
                tx.rollback();
            }
            ex.printStackTrace();
        }
        return currentUser;
    }

    public static boolean signUpUser(String name,String mail, String password){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            currentUser = new UsersEntity();
            currentUser.setUserName(name);
            currentUser.setUserEmail(mail);
            currentUser.setUserPassword(password);
            session.save(currentUser);
            tx.commit();
        }
        catch (Exception ex){
            if(tx!=null){
                tx.rollback();
                return false;
            }
            ex.printStackTrace();
        }
        return true;
    }

    public static List<String> userData(){
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy",Locale.ENGLISH);
        List<String> data = new ArrayList<>();
        data.add("User name: "+ currentUser.getUserName());
        if(currentUser.getUserBirthday()!=null) {
            data.add("User birthday: " + sdf.format(currentUser.getUserBirthday()));
        }
        if(currentUser.getUserLocation()!=null)
            data.add("User Location: "+ currentUser.getUserLocation());
        if(currentUser.getUserAbout()!=null)
            data.add("About user: "+ currentUser.getUserAbout());
        return data;
    }

    public static boolean updateUser(String pass, String mail, String pic, String date, String loc, String about){
        Transaction tx = null;
        UsersEntity user = currentUser;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            if(pass!=null && pass.length()>6)
                user.setUserPassword(pass);
            if(mail!=null && mail.length()>1)
                user.setUserEmail(mail);
            if(pic!=null && pic.length()>1)
                user.setUserPic(pic);
            if(date!=null && date.length()>1) {
                SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    java.util.Date birth = form.parse(date);
                    Date upDate = new Date(birth.getTime());
                    user.setUserBirthday(upDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if(loc!=null && loc.length()>1)
                user.setUserLocation(loc);
            if(about!=null && about.length()>1)
                user.setUserAbout(about);
            session.update(user);
            tx.commit();
        }
        catch (Exception ex){
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
            return false;
        }
        currentUser = user;
        return true;
    }
}
