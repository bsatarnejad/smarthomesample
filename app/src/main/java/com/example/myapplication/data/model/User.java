package com.example.myapplication.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class User {

    private String userId;
    private String displayName;
    public String username;
    public  String password;

    public User(String userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
        this.username = null;
        this.password = null;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}