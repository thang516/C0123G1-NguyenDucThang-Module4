package com.example.demo.repository;

import com.example.demo.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProducerRepository extends JpaRepository<Producer ,Integer> {


}
