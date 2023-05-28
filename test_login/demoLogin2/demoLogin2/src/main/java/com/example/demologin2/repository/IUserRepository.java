package com.example.demologin2.repository;

import com.example.demologin2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IUserRepository extends JpaRepository<User,Integer> {


    @Query(value = "SELECT u FROM User u WHERE u.userName LIKE :userName ")
    User findUser(String userName);
}
