package com.example.customer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name", nullable = false, unique = true, columnDefinition = "VARCHAR(100)")
    private String userName;

    @NotNull
    private String password;
    @NotNull
    private String confirmPassword;

    @Column(name = "your_name", nullable = false, columnDefinition = "VARCHAR(100)")
    private String yourName;

    @Column(name = "phone_number", nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
    private String phoneNumber;

    @Column(name = "gender", nullable = false, columnDefinition = "BIT DEFAULT  0 ")
    private Integer gender;
    @NotNull
    private String email;

    public Customer() {
    }

    public Customer(Integer id, String userName, String password, String confirmPassword, String yourName, String phoneNumber, Integer gender, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.yourName = yourName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
    }

    public Customer(String userName, String password, String confirmPassword, String yourName, String phoneNumber, Integer gender, String email) {
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.yourName = yourName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getYourName() {
        return yourName;
    }

    public void setYourName(String yourName) {
        this.yourName = yourName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
