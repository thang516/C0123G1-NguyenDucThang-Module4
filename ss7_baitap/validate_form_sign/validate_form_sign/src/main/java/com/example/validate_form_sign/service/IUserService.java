package com.example.validate_form_sign.service;

import com.example.validate_form_sign.model.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    void save(User user);
}
