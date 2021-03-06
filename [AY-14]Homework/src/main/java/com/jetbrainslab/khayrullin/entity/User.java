package com.jetbrainslab.khayrullin.entity;

import com.jetbrainslab.khayrullin.enums.Role;
import com.jetbrainslab.khayrullin.enums.UserStatus;

public class User {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Role role;
    private UserStatus userStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public String getRoleString() {
        return role.toString();
    }

    public String getStatusString() {
        return userStatus.toString();
    }
}
