package com.example.demo.service;

import com.example.demo.model.Producer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProducerService {

    Page<Producer> getAllPage(int page);

    List<Producer> getAll();

    void save(Producer producer);
}
