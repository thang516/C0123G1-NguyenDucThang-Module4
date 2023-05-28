package com.example.dangky.repository;

import com.example.dangky.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<User,Integer> {

//
//    @Query(value = "SELECT u FROM User u WHERE u.userName LIKE :userName ")
//    User findUser(String userName);
}
