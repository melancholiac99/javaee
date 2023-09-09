package com.sbjv.sportplay.bean;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String role;
    private boolean state;

    public User() {
    }

    public User(String name, String password, String email, String role, boolean state) {
        this.username = name;
        this.password = password;
        this.email = email;
        this.role = role;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public boolean getState() {
        return state;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.username = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", state=" + state +
                '}';
    }
}
