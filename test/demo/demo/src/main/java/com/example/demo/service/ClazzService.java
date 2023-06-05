package com.example.demo.service;

import com.example.demo.model.Clazz;
import com.example.demo.repository.IClazzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzService implements IClazzService{
    @Autowired
    private IClazzRepository clazzRepository ;

    @Override
    public List<Clazz> findAll() {
        return clazzRepository.findAll();
    }

    @Override
    public void save(Clazz clazz) {
        clazzRepository.save(clazz);
    }
//    @Override
//    public List<Clazz> findAll() {
//        return clazzRepository.findAll();
//    }
//
//    @Override
//    public void save(Clazz clazz) {
//        clazzRepository.save(clazz);
//    }
}
