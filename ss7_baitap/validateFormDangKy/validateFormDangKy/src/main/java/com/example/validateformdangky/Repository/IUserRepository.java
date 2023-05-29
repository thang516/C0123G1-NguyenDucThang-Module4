package com.example.validateformdangky.Repository;

import com.example.validateformdangky.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
