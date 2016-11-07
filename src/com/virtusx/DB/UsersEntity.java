package com.virtusx.DB;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "users", schema = "mydb")
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
    @Column(name = "user_pic", length = 100)
    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    @Basic
    @Column(name = "user_birthday")
    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    @Basic
    @Column(name = "user_location", length = 100)
    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    @Basic
    @Column(name = "user_about", length = 300)
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

        return userId == that.userId && (userName != null ? userName.equals(that.userName) : that.userName == null && (userPassword != null ? userPassword.equals(that.userPassword) : that.userPassword == null && (userEmail != null ? userEmail.equals(that.userEmail) : that.userEmail == null && (userPic != null ? userPic.equals(that.userPic) : that.userPic == null && (userBirthday != null ? userBirthday.equals(that.userBirthday) : that.userBirthday == null && (userLocation != null ? userLocation.equals(that.userLocation) : that.userLocation == null && (userAbout != null ? userAbout.equals(that.userAbout) : that.userAbout == null)))))));

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
