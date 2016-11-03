package com.virtusx.DB;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by x-13 on 02.11.2016.
 */
@Entity
@Table(name = "users", schema = "mydb", catalog = "")
public class UsersEntity {
    private int userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userPic;
    private Date userBirthday;
    private String userLocation;
    private String userAbout;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 45)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_password", nullable = false, length = 45)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_email", nullable = false, length = 45)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user_pic", nullable = true, length = 100)
    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    @Basic
    @Column(name = "user_birthday", nullable = true)
    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    @Basic
    @Column(name = "user_location", nullable = true, length = 100)
    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    @Basic
    @Column(name = "user_about", nullable = true, length = 300)
    public String getUserAbout() {
        return userAbout;
    }

    public void setUserAbout(String userAbout) {
        this.userAbout = userAbout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (userId != that.userId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;
        if (userEmail != null ? !userEmail.equals(that.userEmail) : that.userEmail != null) return false;
        if (userPic != null ? !userPic.equals(that.userPic) : that.userPic != null) return false;
        if (userBirthday != null ? !userBirthday.equals(that.userBirthday) : that.userBirthday != null) return false;
        if (userLocation != null ? !userLocation.equals(that.userLocation) : that.userLocation != null) return false;
        if (userAbout != null ? !userAbout.equals(that.userAbout) : that.userAbout != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userPic != null ? userPic.hashCode() : 0);
        result = 31 * result + (userBirthday != null ? userBirthday.hashCode() : 0);
        result = 31 * result + (userLocation != null ? userLocation.hashCode() : 0);
        result = 31 * result + (userAbout != null ? userAbout.hashCode() : 0);
        return result;
    }
}
