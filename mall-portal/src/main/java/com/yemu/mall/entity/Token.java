package com.yemu.mall.entity;

public class Token {
    private String uid;
    private String token;
    public Token(String token){
        this.token=token;
    }
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
