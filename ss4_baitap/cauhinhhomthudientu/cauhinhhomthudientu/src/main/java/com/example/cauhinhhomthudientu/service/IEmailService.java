package com.example.cauhinhhomthudientu.service;

import com.example.cauhinhhomthudientu.model.Email;
import org.springframework.stereotype.Service;

public interface IEmailService {
    void update(Email email);

    Email getAll();
}
