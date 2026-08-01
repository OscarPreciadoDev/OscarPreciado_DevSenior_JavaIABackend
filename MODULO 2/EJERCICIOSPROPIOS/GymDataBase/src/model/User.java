package com.gym.model;

import java.sql.Timestamp;

public class User {

    private int id;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private UserType userType;
    private Timestamp createdAt;

    public User() {
    }

    // Constructor sin id, útil al crear un usuario nuevo antes del INSERT
    public User(String firstName, String secondName, String email, String password, UserType userType) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    // Constructor completo, útil al mapear un ResultSet
    public User(int id, String firstName, String secondName, String email, String password,
                UserType userType, Timestamp createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                ", createdAt=" + createdAt +
                '}';
    }
}
