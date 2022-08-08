package com.example.taxservice.entity;

import java.util.Objects;

public class User {
    private int id;
    private String login;
    private String password;
    private boolean isInspector;
    private boolean isLegal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
                ", login='" + login + '\'' +
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
        return id == user.id && isInspector == user.isInspector && isLegal == user.isLegal && Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, isInspector, isLegal);
    }
}
