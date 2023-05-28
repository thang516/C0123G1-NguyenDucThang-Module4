package com.example.dangky.service;

import com.example.dangky.model.User;
import com.example.dangky.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository ;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();

    }


//    @Override
//    public User findUser(String userName) {
//        return userRepository.findUser(userName);
//    }
}
