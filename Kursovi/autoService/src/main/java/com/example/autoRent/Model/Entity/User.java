package com.example.autoRent.Model.Entity;

import java.sql.Date;

public class User {
    private int iduser;
    private String role;
    private String name;
    private String surname;
    private String gender;
    private String email;
    private String password;
    private String phoneNumber;
    private Date dateOfBirthday;
    private boolean banStatus;

    public User(int iduser, String name, String surname, String email, boolean banStatus) {
        this.iduser = iduser;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.banStatus = banStatus;
    }

    public User(int iduser, String role, String name, String surname, String gender, String email, String password, String phoneNumber, Date dateOfBirthday, boolean banStatus) {
        this.iduser = iduser;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.dateOfBirthday = dateOfBirthday;
        this.banStatus = banStatus;
    }

    public User() {
    }


    public User(String name, String surname, String gender, String email, String password, String phoneNumber, Date dateOfBirthday) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.dateOfBirthday = dateOfBirthday;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public boolean getBanStatus() {
        return banStatus;
    }

    public void setBanStatus(boolean banStatus) {
        this.banStatus = banStatus;
    }
}
