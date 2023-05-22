package com.example.cauhinhhomthudientu.repository;

import com.example.cauhinhhomthudientu.model.Email;

public interface IEmailRepository {
    void update(Email email);

    Email getAll();
}
