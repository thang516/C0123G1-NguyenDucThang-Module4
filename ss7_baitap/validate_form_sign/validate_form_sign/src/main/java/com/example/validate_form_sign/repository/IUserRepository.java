package com.example.validate_form_sign.repository;

import com.example.validate_form_sign.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
