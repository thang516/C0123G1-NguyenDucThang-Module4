package com.example.validate_form_sign.service;

import com.example.validate_form_sign.Repository.IUserRepository;
import com.example.validate_form_sign.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {

        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
