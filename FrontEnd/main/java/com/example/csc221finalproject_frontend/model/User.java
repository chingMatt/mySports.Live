package com.example.csc221finalproject_frontend.model;





public class User {
    private String userid;
    private String password;
    private String fullName;

    public String getUsername() {
        return userid;
    }

    public void setUsername(String username) {
        this.userid = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
