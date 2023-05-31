package com.example.customer.dto;

import javax.validation.constraints.*;

public class CustomerDTO {
    private Integer id;

    @Size(max = 100, message = "limit is 100 characters")
    @NotBlank(message = "You must fill in all the information")
    private String userName;
    @Size(max = 100, message = "limit is 100 characters")
    @NotBlank(message = "You must fill in all the information")
    private String password;
    @Size(max = 100, message = "limit is 100 characters")
    @NotBlank(message = "You must fill in all the information")
    private String confirmPassword;

    @Size(max = 100, message = "name cannot be longer than 100 characters")
    @Pattern(regexp = "^([A-Z])([a-z])*((\\s)[A-Z]([a-z]*)){0,4}$", message = "malformed name")
    private String yourName;

    @Pattern(regexp = "^0[0-9]{9,10}$", message = "Invalid phone number")
    private String phoneNumber;

    private Integer gender;
    @Email
    private String email;

    public CustomerDTO(Integer id, String userName, String password, String confirmPassword, String yourName, String phoneNumber, Integer gender, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.yourName = yourName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
    }

    public CustomerDTO(String userName, String password, String confirmPassword, String yourName, String phoneNumber, Integer gender, String email) {
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.yourName = yourName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
    }

    public CustomerDTO() {
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
