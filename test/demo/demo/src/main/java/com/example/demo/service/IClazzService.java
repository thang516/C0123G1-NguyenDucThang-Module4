package com.example.demo.service;

import com.example.demo.model.Clazz;

import java.util.List;

public interface IClazzService {
    List<Clazz> findAll();

    void save(Clazz clazz);
//    List<Clazz> findAll();
//
//    void save(Clazz clazz);
}
