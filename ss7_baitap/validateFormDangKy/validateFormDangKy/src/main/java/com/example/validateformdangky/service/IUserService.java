package com.example.validateformdangky.service;

import com.example.validateformdangky.model.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    void save(User user);
}
