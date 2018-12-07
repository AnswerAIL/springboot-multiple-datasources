package com.springboot.datasources.entity;

import java.io.Serializable;

/**
 * Created by L.Answer on 2018-12-07 10:10
 */
public class UserEntity implements Serializable {

    private Long id;
    private String userName;
    private String password;
    private UserSexEnum userSex;
    private String nickName;

    public UserEntity() {
        super();
    }

    public UserEntity(String userName, String password, UserSexEnum userSex) {
        this.userName = userName;
        this.password = password;
        this.userSex = userSex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserSexEnum getUserSex() {
        return userSex;
    }

    public void setUserSex(UserSexEnum userSex) {
        this.userSex = userSex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}