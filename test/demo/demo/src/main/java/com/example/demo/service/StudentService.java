package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository ;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }
//    @Override
//    public List<Student> findAll() {
//        return studentRepository.findAll();
//    }
//
//    @Override
//    public void save(Student student) {
//        studentRepository.save(student);
//    }
//
//
//
//    @Override
//    public void delete(Integer id) {
//        studentRepository.deleteById(id);
//    }
//
//    @Override
//    public Student findById(Integer id) {
//        return studentRepository.findById(id).get();
//    }
//
//    @Override
//    public void update(Student student) {
//        studentRepository.save(student);
//    }
}
