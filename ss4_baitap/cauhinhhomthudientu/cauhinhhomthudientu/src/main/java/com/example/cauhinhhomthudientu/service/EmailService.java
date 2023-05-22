package com.example.cauhinhhomthudientu.service;

import com.example.cauhinhhomthudientu.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cauhinhhomthudientu.repository.IEmailRepository;

@Service
public class EmailService implements IEmailService{

    @Autowired
    private IEmailRepository emailRepository;

    @Override
    public void update(Email email) {
        emailRepository.update(email);
    }

    @Override
    public Email getAll() {
        return emailRepository.getAll();
    }
}
