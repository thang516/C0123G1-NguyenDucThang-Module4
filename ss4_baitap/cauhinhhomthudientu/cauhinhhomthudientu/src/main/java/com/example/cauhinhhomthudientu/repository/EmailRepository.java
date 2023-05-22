package com.example.cauhinhhomthudientu.repository;

import com.example.cauhinhhomthudientu.model.Email;
import org.springframework.stereotype.Repository;



@Repository
public class EmailRepository implements IEmailRepository{
    static  Email email = new Email("English",25,true,"Thor ");



    @Override
    public void update(Email email1) {
       email = email1 ;
    }

    @Override
    public Email getAll() {


        return email;
    }
}
