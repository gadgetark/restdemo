package com.kc.restdemo.dto;

public class UserAccountSource {

    public static final UserAccountSource EMPTY = new UserAccountSource();

    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


}
