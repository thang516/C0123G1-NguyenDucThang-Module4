package com.example.demo.service;

import com.example.demo.model.Producer;
import com.example.demo.repository.IProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService implements IProducerService {

    @Autowired
    private IProducerRepository producerRepository ;

    @Override
    public Page<Producer> getAllPage(int page) {
        return producerRepository.findAll( PageRequest.of(page,3));
    }

    @Override
    public List<Producer> getAll() {
        return producerRepository.findAll();
    }

    @Override
    public void save(Producer producer) {
        producerRepository.save(producer);
    }
}
