package com.example.poojan.projectjpmc.Models;

public class User {

    private String name;
    private String email;
    private long userContact;
    private String userImgUrl;
    private String token;

    public User(String name, String email, long userContact, String userImgUrl, String token) {
        this.name = name;
        this.email = email;
        this.userContact = userContact;
        this.userImgUrl = userImgUrl;
        this.token = token;
    }

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getUserContact() {
        return userContact;
    }

    public void setUserContact(long userContact) {
        this.userContact = userContact;
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
