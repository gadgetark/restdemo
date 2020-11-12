package com.kc.restdemo.dto;

import com.kc.restdemo.model.UserRepo;

import java.util.List;

public class UserFullInfo {

    private String user_name;

    private List<UserRepo> repos;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public List<UserRepo> getRepos() {
        return repos;
    }

    public void setRepos(List<UserRepo> repos) {
        this.repos = repos;
    }
}
