package com.kc.restdemo.dto;

import com.kc.restdemo.model.UserRepo;

import java.util.List;

public class UserFullInfo {

    private String user_name;

    private List<UserRepo> userRepos;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public List<UserRepo> getUserRepos() {
        return userRepos;
    }

    public void setUserRepos(List<UserRepo> userRepos) {
        this.userRepos = userRepos;
    }
}
