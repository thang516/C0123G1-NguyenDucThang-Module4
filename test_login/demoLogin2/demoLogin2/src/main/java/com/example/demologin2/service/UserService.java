package com.example.demologin2.service;

import com.example.demologin2.model.User;
import com.example.demologin2.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository ;


    @Override
    public User findUser(String userName) {
        return userRepository.findUser(userName);
    }
}