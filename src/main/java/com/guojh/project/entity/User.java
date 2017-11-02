package com.guojh.project.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/25.
 */
@Entity
@Table(name = "t_user")
public class User implements Serializable{

    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_sex")
    private String userSex;
    @Column(name="user_location")
    private String userLocation;
    @Column(name="user_sign")
    private String userSign;
    @Column(name = "user_img")
    private String userImg;
    @Column(name="user_reliname")
    private String userReliname;
    @Column(name="user_status")
    private String userStatus;
    @Column(name="user_mobilephone")
    private String userMobilePhone;
    @Column(name="user_password")
    private String userPassword;
    @Column(name = "user_salt")
    private String userSalt;

    public User() {
    }

    public User(String userId, String userName, String userSex, String userLocation, String userSign, String userImg, String userReliname, String userStatus, String userMobilePhone, String userPassword, String userSalt) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userLocation = userLocation;
        this.userSign = userSign;
        this.userImg = userImg;
        this.userReliname = userReliname;
        this.userStatus = userStatus;
        this.userMobilePhone = userMobilePhone;
        this.userPassword = userPassword;
        this.userSalt = userSalt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserReliname() {
        return userReliname;
    }

    public void setUserReliname(String userReliname) {
        this.userReliname = userReliname;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserMobilePhone() {
        return userMobilePhone;
    }

    public void setUserMobilePhone(String userMobilePhone) {
        this.userMobilePhone = userMobilePhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userLocation='" + userLocation + '\'' +
                ", userSign='" + userSign + '\'' +
                ", userImg='" + userImg + '\'' +
                ", userReliname='" + userReliname + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userMobilePhone='" + userMobilePhone + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSalt='" + userSalt + '\'' +
                '}';
    }
}
