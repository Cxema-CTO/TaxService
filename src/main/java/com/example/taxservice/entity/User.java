package com.example.taxservice.entity;

import java.util.Objects;

public class User {
    private int id;
    private String userName;
    private String password;
    private boolean isInspector;
    private boolean isLegal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isInspector() {
        return isInspector;
    }

    public void setInspector(boolean inspector) {
        isInspector = inspector;
    }

    public boolean isLegal() {
        return isLegal;
    }

    public void setLegal(boolean legal) {
        isLegal = legal;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isInspector=" + isInspector +
                ", isLegal=" + isLegal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && isInspector == user.isInspector && isLegal == user.isLegal && Objects.equals(userName, user.userName) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, isInspector, isLegal);
    }
}
