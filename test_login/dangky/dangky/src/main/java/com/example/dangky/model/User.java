package com.example.dangky.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity

@Table(name = "user_sign_in")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String userName;
    @NotNull
    private String pass;
    @NotNull
    private String confirmPass;
    @NotNull
    private String name;
    @Column(name = "phone", nullable = false, unique = true, columnDefinition = "VARCHAR(11)")
    private String phone;
    private String email;
    @Column(name = "gender", nullable = false, columnDefinition = "BIT ")
    private Integer gender;

    public User(Integer id, String userName, String pass, String confirmPass, String name, String phone, String email, Integer gender) {
        this.id = id;
        this.userName = userName;
        this.pass = pass;
        this.confirmPass = confirmPass;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }

    public User() {
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
