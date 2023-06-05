package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    void delete(Integer id);

    Student findById(Integer id);

    void update(Student student);
//
//    List<Student> findAll();
//
//    void save(Student student);
//
//
//    void delete(Integer id);
//
//    Student findById(Integer id);
//
//    void update(Student student);
}
