package com.example.kursaaach.service;

public class Session {
    private String username;
    private String role;

    public Session() {
        this.username = null;
        this.role = null;
    }

    public Session(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isAuthenticated() {
        return username != null && role != null;
    }

    public void invalidate() {
        this.username = null;
        this.role = null;
    }
}