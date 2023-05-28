package com.example.dangky.service;

import com.example.dangky.model.User;

import java.util.List;

public interface IUserService {
    void save(User user);

    List<User> getAll();


//    User findUser(String userName);
}
